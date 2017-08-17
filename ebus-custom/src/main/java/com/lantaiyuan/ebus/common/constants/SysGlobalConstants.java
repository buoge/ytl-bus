package com.lantaiyuan.ebus.common.constants;
/**
 * 描述:该文件用于保存系统所用到的一些常量
 * 作者:温海金
 * 最后更改时间:下午5:25:21
 */
public class SysGlobalConstants {
    /**
     * 附件上传的时候，如果名称不带扩展名，则使用以下默认扩展名
     */
    public static final String PICTURE_SUFFIX = "jpg";
    
    /**
     * @author yangyang
     * 
     * 两个站点之间的距离小于此值，认为是同一站点
     */
    public static final int SAME_DISTANCE = 5000;
    
    /**
     * @author yangyang
     * 
     * 中国最小的纬度
     */
    public static final double CN_MIN_LAT = 3.52;
    
    /**
     * @author yangyang
     * 
     * 中国最大的纬度
     */
    public static final double CN_MAX_LAT = 53.33;
    
    /**
     * @author yangyang
     * 
     * 中国最小的经度
     */
    public static final double CN_MIN_LON = 73.40;
    
    /**
     * @author yangyang
     * 
     * 中国最大的经度
     */
    public static final double CN_MAX_LON = 135.230;
    /**
     * Tools.generateRanNum生成随机数的上限
     */
    public static final int TOOLS_MAX = 999999 ;
    /**
     * Tools.generateRanNum生成随机数的下限
     */
    public static final int TOOLS_MIN = 100000;
    
    /**
	 * 成功返回码
	 */
	public static final Integer SUCCESS_CODE = 200;
	
	/**
	 * 错误码
	 * 默认通用失败返回码
	 */
	public static final Integer ERROR_CODE = 101;
	
	/**
	 * 错误码
	 * 必选参数为空
	 */
	public static final Integer ERROR_CODE_PARAM_IS_NULL = 102;
	
	/**
	 * 错误码
	 * 对象被其它地方引用
	 */
	public static final Integer ERROR_CODE_OBJECT_WAS_USED = 103;
	
	/**
	 * 错误码
	 * 结果或对象不存在
	 * 一般用在查询某一对象，结果为空，使用时可根据实际使用，是否需要返回这个
	 */
	public static final Integer ERROR_CODE_OBJECT_NOT_EXIST = 104;
	
	/**
	 * 错误码
	 * 对象状态异常
	 * 使用某一对象时，该对象状态不允许
	 */
	public static final Integer ERROR_CODE_OBJECT_UNEXPECTED_STATUS = 105;
	
	/**
	 * 错误码
	 * 往数据库插入数据时，唯一性约束的字段出现数据重复
	 */
	public static final Integer ERROR_CODE_OBJECT_DUPLICATE_KEY = 106;
	
	/**
	 * 错误码
	 * 传入参数的值不符合规范，如期望传状态参数值是1或2，实际传了一个3
	 */
	public static final Integer ERROR_CODE_UNEXPECTED_VALUE = 107;
	
	/**
	 * 错误码
	 * 用户登录状态失效
	 */
	public static final Integer ERROR_CODE_USER_LOGIN_STATE_INVALIDE = 110;
	
	/**
	 * 错误码 
	 * 用户无权限
	 */
	public static final Integer ERROR_CODE_USER_NO_AUTH = 111;
	
	
	/**
	 * 走路的速度
	 */
	public static final Integer WALK_SPEED = 60;
	
	
	/**
	 * 一个站二分钟
	 * 用户无权限
	 */
	public static final Integer SPEND_TIME_EVERY_STATION = 2 * 60;
	
	/**
	 * 附近站点距离默认500米
	 */
	public static final Integer DEFAULT_DISTANCE = 500;
	
	/**
	 * 附近站点5分钟距离默认500米
	 */
	public static final Integer FIVE_DISTANCE = 500;
	
	/**
	 * 附近站点10分钟距离默认1000米
	 */
	public static final Integer TEN_DISTANCE = 1000;
	/**
	 * 附近站点采用3000M范围进行过滤
	 */
	public static final Integer THREE_KM = 3000;
	
	public static final String PROTOCOLVER = "HDBS";
	
	public static final String PACKETTYPE_GPS = "gps";
	
	public static final String PACKETYPE_IN_STATION = "inStation";
	
	/**
	 * 如果时间相差二分钟及以上就不要当前车辆信息
	 */
	public static final Integer TIME_DIFF = 2;
	
	public static final Integer BENGBU_TIME_DIFF = 60;
	
	public static final Integer DEFAULT_STATION_DISTANCE = 500;
	

	/**
	 * app用户登录方式
	 */
	public static final String APP_USER_TPYE_PHONEUSER = "0";// 手机
	
	public static final String APP_USER_TPYE_WECHATUSER = "1";// 微信
	
	public static final String APP_USER_TPYE_QQUSER = "2";// QQ用户
	
	public static final String APP_USER_TPYE_MICROBLOGUSER = "3";// 微博
	
	/**
	 * APP用户登录状态 ：1-离线
	 */
	public static final Integer LOGIN_OFF_LINE = 1;
	
	/**
	 * APP用户登录状态 ：0-在线
	 */
	public static final Integer LOGIN_ON_LINE = 0;
	
	/**
	 * 存储在MongoDB的表名
	 * 记录用户初次启动app的时间和城市
	 * @author yangyang
	 */
	public static final String USER_START_APP = "user_start_app";
	
	public static final String QUESTIONNAIRE = "questionnaire";
	
	/**
	 * 公交车辆默认行驶速度（公里/小时）
	 */
	public static final int SPEED = 30;
	/**
	 * 每分钟60秒
	 */
	public static final int SECONDS_PER_MIN = 60;
	
	/**
	 * 微信回调成功，返回给微信的成功字符串
	 * @author YvanTan
	 */
	public static final String WEI_XIN_RETURN_SUCCESS = "<xml><return_code><![CDATA[SUCCESS]]></return_code><return_msg><![CDATA[OK]]></return_msg></xml> ";
	
	/**
	 * utf-8
	 * @author YvanTan
	 */
	public static final String UNICODE_TRANSFORMATION_FORMAT_8 = "utf-8";
	
	/**
	 * xml
	 * @author YvanTan
	 */
	public static final String XML = "xml";
	
	/**
	 * 支付成功的状态码
	 */
	public static final String PAY_STATUS_SUCCESS_CODE = "1";
	
	/**
	 * 订单未支付的状态码
	 */
	public static final String ORDER_NOT_PAY_CODE = "0";
	
	/**
	 * 成功的状态标识
	 */
	public static final String SUCCESS_FLAG = "SUCCESS";
	
	/**
	 * 车票订单
	 */
	public static final int BOOKED_TICKET_ORDER = 1;
	
	/**
	 * 专车订单
	 */
	public static final int BOOKED_BUS_ORDER = 2;
	
	/**
	 * 拼车订单
	 */
	public static final int BOOKED_CARPOOL_ORDER = 3;
	
	/**
	 * 周边游订单
	 */
	public static final int BOOKED_TRAVEL_ORDER = 4;
	
	/**
	 * 成功
	 */
	public static final String SUCCESS_RESPONSE_MSG = "success";
	
	/**
	 * 失败
	 */
	public static final String FAIL_RESPONSE_MSG = "fail";
	
	/**
	 * false
	 */
	public static final String FALSE_RESPONSE_MSG = "false";
	
	/**
	 * order_was_paid
	 */
	public static final String RESPONSE_ORDER_WAS_PAID = "order_was_paid";
	
	/**
	 * total_amount_not_match
	 */
	public static final String RESPONSE_AMOUNT_NOT_MATCH = "total_amount_not_match";
	
	
	/**
	 * 更新数据库单条记录 成功标志
	 */
	public static final int UPDATE_ONE_RECORD_SUCCESS = 1;
	
	/**
	 * 支付宝回调 seller_id
	 */
	public static final String  PARAM_SELLER_ID= "seller_id";
	
	/**
	 *支付宝回调 app_id
	 */
	public static final String  PARAM_APP_ID= "app_id";
	
	/**
	 *支付宝回调  out_trade_no
	 */
	public static final String  PARAM_OUT_TRADE_NO= "out_trade_no";
	
	/**
	 * 支付宝回调 total_amount
	 */
	public static final String  PARAM_TOTAL_AMOUNT= "total_amount";
	
	/**
	 *参数：success
	 */
	public static final String  PARAM_SUCCESS= "success";
	
	/**
	 *参数：msg
	 */
	public static final String  PARAM_MSG= "msg";
	
	/**
	 *参数：data
	 */
	public static final String  PARAM_DATA= "data";
	
	
	public static final String USER_SESSION_KEY = "userSession";
	
	/**
	 * 失物招领简要信息长度
	 */
	public static final Integer BRIEF_LENGTH = 100;
	
	/**
	 *参数：flag
	 */
	public static final String PARAM_FLAG = "flag";
	
	/**
	 *返回值：成功状态
	 */
	public static final String RETURN_SUCCESS_CODE = "0000";
	
	/**
	 *申请成功返回值
	 */
	public static final String APPLY_SUCCESS_MESSAGE = "申请成功";
	
	/**
	 *加入成功返回值
	 */
	public static final String JOIN_SUCCESS_MESSAGE = "加入成功";
	
	/**
	 *查询成功返回值
	 */
	public static final String QUERY_SUCCESS_MESSAGE = "查询成功";
	
	/**
	 *参数：车票列表list
	 */
	public static final String  PARAM_TICKET_LIST = "ticketlist";
	
	/**
	 *参数：已预订
	 */
	public static final String  WAS_BOOKED = "1";
	
	/**
	 *参数：未预定
	 */
	public static final String  NOT_BOOKED = "0";
	
	/**
	 * 参数：时间格式 "yyyy-MM-dd"
	 */
	public static final String  PARAM_YYYY_MM_DD = "yyyy-MM-dd";
	
	/**
	 * 参数：用户id userId
	 */
	public static final String  PARAM_USER_ID = "userId";
	
	/**
	 * 参数：routeId
	 */
	public static final String  PARAM_ROUTE_ID = "routeId";
	
	/**
	 * 参数：cityCode
	 */
	public static final String  PARAM_CITY_CODE = "cityCode";
	
	/**
	 * 参数：takeDate
	 */
	public static final String  PARAM_TAKE_DATE = "takeDate";
	
	/**
	 * 参数：orderno
	 */
	public static final String  PARAM_ORDER_NO = "orderno";
	
	/**
	 *返回值：订票失败
	 */
	public static final String BOOKED_TICKET_FAIL = "0001";
	/**
	 *返回值：订票成功
	 */
	public static final String BOOKED_TICKET_SUCCESS = "0002";
	
	/**
	 *返回值：取消订票
	 */
	public static final String CANCEL_BOOKED_TICKET = "0003";
	
	/**
	 *返回值：失效的订单
	 */
	public static final String INVALID_TICKET_ORDER = "0004";
	
	/**
	 * 参数：timestamp
	 */
	public static final String  PARAM_TIME_STAMP = "timestamp";
	
	/**
	 * 参数：httpCode
	 */
	public static final String  PARAM_HTTP_CODE = "httpCode";
	
	/**
	 * 参数：paysign
	 */
	public static final String  PARAM_PAY_SIGN = "paysign";
	
	/**
	 * 参数：subject
	 */
	public static final String  PARAM_SUBJECT = "subject";
	
	/**
	 * 参数：body
	 */
	public static final String  PARAM_BODY = "body";
	
	/**
	 * 参数：微信调用的appid
	 */
	public static final String  PARAM_WEIXIN_APP_ID = "appid";
	
	/**
	 * 微信调用的appid值
	 */
	public static final String  APP_ID_VALUE = "wxd92fddab3c359448";
	
	/**
	 * 参数：微信调用的partnerid
	 */
	public static final String  PARAM_PARTNER_ID = "partnerid";
	
	/**
	 * 微信调用的partnerid值
	 */
	public static final String  PARTNER_VALUE = "1301124501";
	
	/**
	 * 参数：微信调用的prepayid
	 */
	public static final String  PARAM_PREPAY_ID = "prepayid";
	
	/**
	 * 参数：微信调用的package
	 */
	public static final String  PARAM_PACKEAGE = "package";
	
	/**
	 * 微信调用的package值
	 */
	public static final String  PACKEAGE_VALUE = "Sign=WXPay";
	
	/**
	 * 参数：微信调用的noncestr
	 */
	public static final String  PARAM_NONCESTR = "noncestr";
	
	/**
	 * 参数：微信调用的sign
	 */
	public static final String  PARAM_SIGN = "sign";
	
	/**
	 *成功
	 */
	public static final String RETURN_SUCCESS_MESSAGE = "成功";
	
	/**
	 * 参数：orderstatus
	 */
	public static final String  PARAM_ORDER_STATUS = "orderstatus";
	
	/**
	 * 支付宝交易成功标识
	 */
	public static final String  ALIPAY_TRADE_SUCCESS = "TRADE_SUCCESS";

	public static final String PARAM_OBJ = "obj";

	/**
	 * 参数："ticketcode"
	 */
	public static final String PARAM_TICKET_CODE = "ticketcode";
	
	/**
	 * 评价分数："很不满意"
	 */
	public static final int EVALUATION__WORST_SCORE = 0;

	/**
	 * 评价分数："很不满意"
	 */
	public static final int EVALUATION__TERRIBLE_SCORE = 20;

	/**
	 * 评价分数："不满意"
	 */
	public static final int EVALUATION__AWFUL_SCORE = 25;

	/**
	 * 评价分数："不满意"
	 */
	public static final int EVALUATION__WRONG_SCORE = 40;

	/**
	 * 评价分数："不满意"
	 */
	public static final int EVALUATION__BAD_SCORE = 50;

	/**
	 * 评价分数："一般"
	 */
	public static final int EVALUATION__COMMON_SCORE = 60;

	/**
	 * 评价分数："满意"
	 */
	public static final int EVALUATION__GOOD_SCORE = 75;

	/**
	 * 评价分数："满意"
	 */
	public static final int EVALUATION__FINE_SCORE = 80;

	/**
	 * 评价分数："很满意"
	 */
	public static final int EVALUATION__GREAT_SCORE = 100;
	
	/***
	 * 高德KEY
	 */
	public static final String GAODE_API_KEY = "a3d71b377c959187a7ca63afd4f2d644";
	
	/***
	 * 高德output 输出格式
	 */
	public static final String GAODE_API_OUTPUT = "JSON";
	
	/***
	 * 高德api url
	 */
	public static final String GAODE_API_URL = "http://restapi.amap.com/v3/place/text";
	
	/***
	 * 高德api 需要排除的类别代码
	 */
	public static final String GAODE_EXCLUDE_CODE = "150700,150701,150702,150703";
	
	/***
	 * 参数：钱包余额
	 */
	public static final String PARAM_WALLET_BALANCE = "balance";
	
	/***
	 * 参数：钱包冻结状态
	 */
	public static final String PARAM_WALLET_FROZEN_STTUS = "frozen";

	/**
	 * admin用户（蓝泰源用户）对应的cityCode
	 */
	public static final String ADMIN_CITYCODE = "-1";

	
	/**
	 * 消息推送类别，具体定义参考枚举JpushTypeEnum
	 */
	public static String MSG_TYPE = "msgType";
	
}
