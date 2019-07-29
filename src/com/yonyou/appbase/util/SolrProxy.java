package com.yonyou.appbase.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;

import com.yonyou.component.feedback.entity.FeedbackItem;

/**
 * @author: lugl9
 * @description:
 * @date: Created in 下午4:34 2018/3/6
 * @modified by:
 */
public class SolrProxy {
	private static Properties properties = PropsUtil.loadProps("conf.properties");
	private static SolrServer solrServer = new HttpSolrServer(PropsUtil.getString(properties, "solrUrl"));

	/**
	 * 搜索
	 * @param query
	 * @return
	 * @throws Exception
	 */
	public static List<FeedbackItem> search(SolrQuery query) throws Exception{
		QueryResponse response = solrServer.query(query);
		SolrDocumentList solrDocuments = response.getResults();
		List<FeedbackItem> result = new ArrayList<FeedbackItem>();
		for (SolrDocument document : solrDocuments) {
			FeedbackItem feedbackItem = new FeedbackItem();
			feedbackItem.setPkFeedback((String) document.get("id"));
			feedbackItem.setReplycontent((String) document.get("replycontent"));
			feedbackItem.setReplytime((String) document.get("replytime"));
			feedbackItem.setAsktime((String) document.get("asktime"));
			feedbackItem.setAskcontent((String) document.get("askcontent"));
			feedbackItem.setQuestionTypeName((String) document.get("question_type_name"));
			result.add(feedbackItem);
		}
		return result;
	}

	/**
	 * 同步solr
	 * @return
	 */
	public static void syncSolr(List<FeedbackItem> itemList) throws Exception {
		for (FeedbackItem item : itemList) {
			SolrInputDocument document = new SolrInputDocument();
			document.addField("id", item.getPkFeedback());
			document.addField("askcontent", item.getAskcontent());
			document.addField("replycontent", item.getReplycontent());
			document.addField("asktime", item.getAsktime());
			document.addField("replytime", item.getReplytime());
			document.addField("question_type_name", item.getQuestionTypeName());
			solrServer.add(document);
		}
		solrServer.commit();
	}

	/**
	 * 删除索引
	 * @throws Exception
	 */
	public static void deleteSolrIndex() throws Exception {
		solrServer.deleteByQuery("*:*");
		solrServer.commit();
	}
}
