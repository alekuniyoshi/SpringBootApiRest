package com.akuniyoshi.springboot.backend.apirest.auth;

public class JwtConfig {
	public static final String Secret_key = "My_super_secrey_key";
	
	public static final String RSA_PRIVATE ="-----BEGIN RSA PRIVATE KEY-----\n"
			+ "MIIEogIBAAKCAQEAuIKk5dfEYrVKaCI71F2kaaKZWuRgWmtCfOHvjntiGlVEYvKv\n"
			+ "HR6HEemNl2grOW1IpOpbK7ZwhgIA9NsyhfyISGLpveyEavWmOCv6B1mJO3vzuc/Z\n"
			+ "WyWFjK4qz5J1I9B1Qp6yWwKVnGMPFzpsb8kqN2YQMeQDXgT4xxg3gWyLwb7nas1G\n"
			+ "IXk22pfFHqyys5MpxWRL6zFINtr/J7LBy5CQcaqMVHC+gBWpTjb73B19qP79PD6M\n"
			+ "6XjBrI0FP2HlJZxaCDw75meLUzI5j0llPGhNWY4ibZzLjEriMsyhN/nMLIK/0tiI\n"
			+ "hbQweyZMN6tSb1bKV4umEiHnZaRshgFrlbiq4QIDAQABAoIBABs9FjDkQJa94sUq\n"
			+ "wKBiTqJVocQcUOkoSoF7LU1gg6QVkGn3H8jxt8j6LK/8bd0leAL4ogr6/PObmh6L\n"
			+ "uZK0LD5bc9xY7VeI+kfyng+1tR+19c4plBHzoRqan7FTEr39yUHTgcsTv5h9uz2X\n"
			+ "n2iFTxkslRl4atLXcw6ZUaBmsN8iGnVVJROjH0M9sNP2R4yUqOClioRAwmk9GTGz\n"
			+ "cR/KhDIKmg+4UREmpmbonb3UsOZI5+3HWaBmdClZSETkGoNLM0vM63Jt7UKIxYXX\n"
			+ "k9YnZVBJeNWQK58iu/XoQk0F6hgn6AMY/p4RJe211VxUUe7uCf4vY0h2gWxqjiSF\n"
			+ "1dqpsV0CgYEA43Q7OcwX5C9sIm5mbmv1etKo3HpsgGs2AzmuWv3xd1HF6nDhHoEG\n"
			+ "FlAYA8OnpZUC6rgsQJ2G+UfVxXsNgYDM2kmkEf43vHphC9QD/aIgDtHWI+/3RnD3\n"
			+ "U9HVDfG2J7rKC4znGgSJRBTJydv2kiQ6ge0h8z+wOKCfdYZlizZrrIMCgYEAz6qx\n"
			+ "oWolXglsCYVoEapiqmOSoTeU2Aq86z0kXqyAzUaOcxllo4DNK+qX0iqnQH1acwYP\n"
			+ "05fNkhpTPZe1U+qDfYxeIWdy/36dQ0DxsaULle+NoOaqfVHFhEEM8w1RFLZAtDGY\n"
			+ "YAC8voxqxO1ZnbrnjNyT1jq6c1e2wsp6V3tVdcsCgYBWAysuZRaXzLMYpiUIFr1C\n"
			+ "0AzZK1aCjYhkWdisQiGg3IR6bmtDDMmPgIREUCXCgQIUXsclPCzBcb/OKQVndpyA\n"
			+ "454uy7KqDKFMRsWnkTqMQB+5gVJCChANW2k1F7WpeoJTMdpmxVZfL3lLY2nvw9F4\n"
			+ "NoNDKE9saplCaStXJKI9HwKBgDtmfezH6exeEZMfn8b9z78hQD3xIhgx6hv3n0Gd\n"
			+ "YjJVbkWqDBKasxVOwyKQpMqjkI26PCiwEVMrSIgjrvBT8kylK/+uEYzXcLBeEURZ\n"
			+ "C1lV7lMJ59Z032SXHtcfBgRApX1lekprq5FtpNSzd6DQZ485QOhUYCTCADrzo88G\n"
			+ "LknFAoGAVU6b48fFq94nzlzMdugxcRdftZpwPlZE1STM5MBlzdtxpleUNw/e2795\n"
			+ "co36TT2T1rF3b8H3MnkCiQaS4HCrcPiL8r0gOIqUU874TDCRh8EVKuKSD2YqdkvB\n"
			+ "2bpV1W1Tk0JZ0YByqpA0ip6X/l7xiWtNihQOhY0LA14GcxzA2Yk=\n"
			+ "-----END RSA PRIVATE KEY-----";

	
	public static final String RSA_PUBLIC ="-----BEGIN PUBLIC KEY-----\n"
			+ "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAuIKk5dfEYrVKaCI71F2k\n"
			+ "aaKZWuRgWmtCfOHvjntiGlVEYvKvHR6HEemNl2grOW1IpOpbK7ZwhgIA9NsyhfyI\n"
			+ "SGLpveyEavWmOCv6B1mJO3vzuc/ZWyWFjK4qz5J1I9B1Qp6yWwKVnGMPFzpsb8kq\n"
			+ "N2YQMeQDXgT4xxg3gWyLwb7nas1GIXk22pfFHqyys5MpxWRL6zFINtr/J7LBy5CQ\n"
			+ "caqMVHC+gBWpTjb73B19qP79PD6M6XjBrI0FP2HlJZxaCDw75meLUzI5j0llPGhN\n"
			+ "WY4ibZzLjEriMsyhN/nMLIK/0tiIhbQweyZMN6tSb1bKV4umEiHnZaRshgFrlbiq\n"
			+ "4QIDAQAB\n"
			+ "-----END PUBLIC KEY-----";
}
