package com.lantaiyuan.ebus.oauthlogin.constant;

public class Constants {

	/**
	 * 以下是访问百度API需要用到的一些常量
	 */
	public static final String BAIDU_ID = "9771083";

	// appid
	public static final String BAIDU_API_KEY = "sYovrsHRZi3HfYz3MFMC7KAk";

	// appkey
	public static final String BAIDU_SECRET_KEY = "qkFTDMwQMWwlalYHsbwGRmB4lMVyBasG";

	public static final String BAIDU_REGISTERED_REDIRECT_URI = "http://localhost:8080/ebus-custom/baidu/code";

	public static final String BAIDU_ACCESS_TOKEN_URL = "https://openapi.baidu.com/oauth/2.0/token"
			+ "?grant_type=authorization_code&code={code}&client_id={BAIDU_API_KEY}"
			+ "&client_secret={BAIDU_SECRET_KEY}&redirect_uri={BAIDU_REGISTERED_REDIRECT_URI}";

	/**
	 * 以下是访问QQ需要的一些常量定义
	 */

	/**
	 * 以下是访问微信需要的一些常量定义
	 */
	public static final String WX_APP_ID = "wxd92fddab3c359448";

	public static final String WX_APP_SECRET = "f59aadf96f57d3beae0c918454235429";

	// 获取access token，access token有效期2h
	public static final String WX_ACCESS_TOKEN_URL = "https://api.weixin.qq.com/sns/oauth2/access_token?"
			+ "appid={WX_APP_ID}&secret={WX_APP_SECRET}&code={CODE}&grant_type=authorization_code";

	// 刷新access token，refresh token有效期30d
	public static final String WX_REFRESH_TOKEN_URL = "https://api.weixin.qq.com/sns/oauth2/refresh_token?"
			+ "appid={WX_APP_ID}&grant_type=refresh_token&refresh_token={WX_REFRESH_TOKEN}";

	/**
	 * 以下是访问支付宝需要的一些常量定义
	 */
	public static final String ALIPAY_APP_ID = "2017061907523796";

	public static final String APP_PRIVATE_KEY = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCKDyrSvQJ5CXOyXZXJznlO2Ry6qdVNK2Ypm0mmEPEEkqaVPbJlcVVZgLkiRJ8PwYdiRu1XqsOdvBScu0j8kdXPzFvTx3Eyz1LjV7ZL1rex6YYDzvWGYItrJfMqg9jRvz9pGaFL2NiiNOtqyKEblRH6G+U8GTkRRz8NB8Zf3zedfY4/jOwCEjUiYGzxjUs2c8OUz631LXQ5GuyxpO+VXE77HyxDNwFmXQ1YmnrcyB4QSJ+RNk6bpNdbJCtn7j12CTPx+/dom5t/i+u1wcqefKiX3NY9w9Gr1gTn8cD2F26hr79LS9YMy3Z/Xn8pzIdRhm9MQaRSBkCZ4K4B4Jt5VjvfAgMBAAECggEAW1MdKLoO4LH37o0pgI0sgZPtBS1DBAEpW2x1k3yxcizwNNjTIXeO1d3omVp7PZjvTXtNlShIrha0K9lXtnthzEuKktTjdJDga7KhzBkE+pNXKz3D/Ffw4bgA2qbMzjKMZ6GkqN+QrfwDnmeI6w35DlFVmiO1NFDEzIHQH6swxuREg1LE7Nnmr4MFia5M6YuzMWOIDnLTvVp9oHphaivR5rOqtNCavxBJA8Fn3lmZwCihSe23cd/6J9EODd1qgDBcG4e5oEUXUPQCh6Nr8U4ReoKaBkK5CqhnBir8tjGGYr2fYGofrf5GRf1aApd1oc0xP1xjzH4gasGZvbFqe5GzQQKBgQDU/m/Oca6LJlRmNa0UJD0L2wW1gY8q2A3062c4t9dhPMWzEuRe69cn+N2zWFdM7XIIu2ouwBEjTuuxdR9YAXtFWxgVhunor4M9hGRCkO5LG+g9Q9RwYUNORFyFz8xpr82aFZJd80eRfUs/MgaUOaH2d61e32pSPxEbcpL9eDo8DQKBgQCl72QF5f9NhnQdtmuh1k7spy72sSgThejDdfpugx2uwZOGRY/Qimznqjj0fg3wxvzAZGykUw2oAKCn349/GQgGbFm3+ozygVuRctqOx9D1dKf+KW6CnJ9dOElMJkGXXgrCoQwwGnjctzlHbquuoiaXdokyvCb66mmBRg+KjwtgmwKBgHwBlv7O2RxSuJi5b4dmgdRBNFW0lLIREC8kTviKsG8Afun/ec556M5w6kLckBdNtzK2St/lGxU/gaHT2ufWFPsQSjleTxkV9ob+aZEH6HT6ToA82ZaESjdrPaL6lLyDimTHYmwok+Z02DZ23bW2yEFC9EFkOfagmUktr767HMyRAoGAbryLq8QJ1NrdstaCjcZPdW880DT54c2DwK2DKy0lKfLVWM4jY7B9bT0UNVXKR90D4AEk36TtgCirDl0Ljm5OBLtaRIVYep4JVc+oO5DtymDHm75amZ+cWsGtaLw/GZ0Q4UJIt/Fypxk/iIQ63pgn2PyqIsmd2eWF81emF3nOxfECgYEAhm/wed/nDZqS0TdDl5lifjFSlnNFoygecre3a8sQ/9taloSUbJKLXy4Ock6H0w+uCG15+qHNNpPVw44Cm3+WJBhSJOAKGSuyFJ5Y94asohrmmNe72U55A41DZNUIQtAPzxoTCxku+fzvrJNAjo77azGcECprIXMSFR7CIUVzec0=";

	public static final String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAo2ujYB0mg2ttbGHubGI5NNYQHPFIZGE0rAVMvrAxBbiIoTJ7WGc5SdBbS3th3maVg/GTsW34bXqkONkjkmn/TDZ/UM+WKV/BuegXsZjx7KEkn2DOE4igl9KPBWAzJH9NvNj95OsB02wcY2qgzQzcdikPz75w4xX598KG8YvnFgdsHjlyseevXWNzRun5Y4Mx45w8OlRd5l3tIhxnbF8o9TWmn8KIKP1hBDgc9U+FEOGLSTuV9D95/FWLwermWBAuaGKyPyfmQslo60UyBOCaJL9nro5quoisyRXCFeagXM7tuDaKPonVv2yz0ir0UTFMoMv1YcptOkGZBZhX2371+QIDAQAB";

	

}
