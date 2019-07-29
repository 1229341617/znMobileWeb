package com.yonyou.component.common;

public enum CodeEnum {

	/*SUCCESS("成功", 0),
	INVALID("token失效", 1),
	PARAMERROR("参数有误", 2),
	NOSPACE("不是主空间", 3),
	SYSTEMERR("系统错误", 10),
	NOPAGE("页面没找到", 11),
	MODIFYERR("修改失败", 20),*/
    C_0("成功", 0),
    C_1("token失效", 1),
    C_2("参数有误", 2),
    C_3("不是主空间", 3),
    C_10("系统错误", 10),
    C_11("页面没找到", 11),
    C_20("修改失败", 20),
	C_21("操作失败",21),
	C_22("corpid或secret无效", 22),

	C_10001("同一空间同一级(机构|部门)名称不能相同",10001),
	C_10002("部门下面不能添加机构",10002),
	C_10003("父类(机构|部门)不存在",10003),
	C_10004("父类与当前id不能相同",10004),
	C_10005("(机构|部门)不存在",10005),
	C_10006("被删除的(机构|部门)下面不能有人员",10006),
	
	C_20001("电话号码和邮箱至少有一个",20001),
	C_20002("名称不能为空",20002),
	C_20003("密码不能为空",20003),
	C_20004("(机构|部门)不存在",20004),
	C_20005("创建用户失败",20005),
	C_20006("加入空间失败",20006),
	C_20007("停用用户失败,请先转移用户下的团队",20007),
	C_20008("此空间下没有这个用户",20008),
	C_20009("此用户已停用",20009),
	C_20010("用户已存在",20010),

	C_30001("token生成失败",30001),
	C_30002("token验证失败",30002),
	C_30003("token失效",30003),
	C_30004("身份验证失败，请重新登录",30004),

	C_40001("空间类型错误",40001),
	C_40002("组织结构Id不正确",40002),
	C_40003("无操作权限",40003),
	C_40004("无配置权限",40004),
	C_40005("实例Id不正确",40005),
	C_40006("请设置圈子信息",40006),

	C_50001("参数不完整",50001),
	C_50002("未知错误",50002),
	/** 获取企业服务码失败 */
    C_50003("获取企业服务码失败",50003),
    C_50004("服务源创建失败",50004),
	
	C_60001("系统累了,歇会儿再来吧",60001),
    
    C_70001("signature签名验证未通过,拒绝访问!",70001),
    
    C_80001("用户名不能为空!",80001),
    C_80002("密码不能为空!",80002),
    C_80003("用户名或密码错误!",80003),
    C_80004("用户未登录或已超时!",80004),
	
	C_90001("临时授权码验证失败!", 90001),
	C_90002("套件id不能为空!", 90002),
	C_90003("临时授权码不能为空!", 90003),
	C_90004("永久授权码不能为空!", 90004),
	C_90005("永久授权码验证失败!", 90005),
	C_90006("套件id不存在",90006),
    /** 套件ticket无效 */
    C_90007("套件ticket无效", 90007),
    /** 缺少 suite_token */
    C_90008("缺少 suite_token",90008),
    /** 套件 suite_token无效 */
    C_90009("套件 suite_token无效",90009),
    /**aes 签名验证错误  */
    C_91001("aes签名验证错误",91001),
    /** aes xml解析失败 */
    C_91002("aes xml解析失败",91002),
    /** aes sha加密生成签名失败 */
    C_91003("aes sha加密生成签名失败",91003),
    /** aes SymmetricKey非法 */
    C_91004("aes SymmetricKey非法",91004),
    /** aes corpid校验失败 */
    C_91005("aes corpid校验失败",91005),
    /** aes 加密失败 */
    C_91006("aes 加密失败",91006),
    /** aes 解密失败 */
    C_91007("aes 解密失败",91007),
    /** aes 解密后得到的buffer非法 */
    C_91008("aes 解密后得到的buffer非法",91008),
    /** 推送suite_ticket socket超时 */
    C_91009("推送suite_ticket socket超时",91009),
    /** 推送suite_ticket 连接异常 */
    C_91010("推送suite_ticket 连接异常 ",91010),

	/** 授权新流程错误码 开始*/
	/** 推送临时授权码 socket超时 */
	C_91011("推送临时授权码 socket超时",91011),
	/** 推送临时授权码 连接异常 */
	C_91012("推送临时授权码 连接异常 ",91012),
	/** 套件授权成功 */
	C_91013("授权成功",91013),
	/** 临时授权码失效,授权失败*/
	C_91014("临时授权码失效,授权失败",91014),
	/** 授权中 **/
	C_91015("授权中",91015),
	/** 授权新流程错误码 开始*/


	C_900010("套件图标不能为空", 900010),
	C_900011("套件名称不能为空", 900011),
	C_900012("行业不能为空", 900012),
    /** 系统缺少帐号校验适用字段 */
	C_92001("系统缺少帐号校验适用字段",92001),
	/** 帐号不存在 */
	C_92002("帐号不存在",92002),
	/** 参数错误（缺少用户Id）*/
	C_92003("参数错误（缺少用户Id）",92003),
	/** 参数错误（缺少空间账户信息）*/
	C_92004("参数错误（缺少空间账户信息）",92004),
	/** 参数错误（缺少第三方账户信息）*/
	C_92005("参数错误（缺少第三方账户信息）",92005),
	/** 参数错误（缺少第三方企业代码）*/
	C_92006("参数错误（缺少第三方企业代码）",92006),
	/** 添加账户对照信息失败(db error)*/
	C_92007("添加账户对照信息失败(db error)",92007),
	/** 添加账户对照信息失败(db error)*/
	C_92008("验证码错误",92008),
	C_92009("文件下载失败",92009),
	C_92010("已经存在isv",92010),
	C_92011("没有权限修改该isv",92011),
	C_92012("没有isv企业资质",92012),
	C_92013("isv企业资质认证中",92013),
	C_92014("isv企业资质认证失败",92014),
	C_92015("创建测试企业空间失败",92015),
	C_92016("应用不存在",92016),
    /** 系统类型不存在 */
    C_92000("系统类型不存在",92000),
    /** agentId不存在 */
    C_5001000("agentId不存在",5001000),
    /** agentId和corpId不匹配 */
    C_5001001("agentId和corpId不匹配",5001001),
    /** js_ticket非法 */
    C_5001002("js_ticket非法",5001002),
    /** js_api授权签名验证失败 */
    C_5001003("js_api授权签名验证失败",5001003),
    /** 已取消套件授权 */
    C_5002000("已取消套件授权",5002000),
    
    // C_93000 ~ C_93999 nc 项目用
    
    	// C_93000 ~ C_93009 Gzip错误码
    /** gzip压缩异常 */
    C_93000("gzip压缩异常", 93000),
    /** gzip压缩关闭流异常 */
    C_93001("gzip压缩关闭流异常", 93001),
    /** gzip解压缩异常 */
    C_93002("gzip解压缩异常", 93002),
    /** gzip解压缩关闭流异常 */
    C_93003("gzip解压缩关闭流异常", 93003),
    
    	// C_93100 ~ C_93199 JsonUtils错误码
    /** Json字符串转换成对象异常 */
    C_93100("Json字符串转换成对象异常", 93100),
    /** 对象转换成Json字符串异常 */
    C_93101("对象转换成Json字符串异常", 93101),
    
    	// C_93200 ~ C_93299 HttpDataProxy 访问MA异常 
    /** MA服务器连接异常 */
    C_93200("MA服务器连接异常", 93200),
    /** MA服务器IO异常 */
    C_93201("MA服务器IO异常", 93201),
    /** MA服务器其他异常 */
    C_93202("MA服务器其他异常", 93202),
    
    	// C_93300 ~ C_93399 DES加解密错误码
    
    /** DES初始化失败 */
    C_93300("DES初始化失败", 93300),
    /** DES加密失败 */
    C_93301("DES加密失败", 93301),
    /** DES解密异常 */
    C_93302("DES解密异常", 93302),
    /** DES编码异常 */ 
    C_93303("DES编码异常", 93303),
    /** DES解码异常 */ 
    C_93304("DES解码异常", 93304),
    
    C_9000000("last", 9000000);

	private int code;

	private String content;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	private CodeEnum(String content, int code) {
		this.code = code;
		this.content = content;
	}

	// 普通方法
	public static String getValue(int code) {
		for (CodeEnum c : CodeEnum.values()) {
			if (c.getCode() == code) {
				return c.content;
			}
		}
		return null;
	}
}
