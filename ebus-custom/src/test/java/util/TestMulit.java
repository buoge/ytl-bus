package util;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.lanqiao.ssm.common.constant.LogConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import com.alibaba.fastjson.JSON;

/**
 * @author liuwei 2015-4-7
 */
/*@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({ "classpath:spring/spring-content.xml", "classpath:/spring-mvc.xml" })*/
// 当然 你可以声明一个事务管理 每个单元测试都进行事务回滚 无论成功与否
@TransactionConfiguration(defaultRollback = true)
@Transactional
public class TestMulit {/*
	private static Logger logger = LoggerFactory.getLogger(TestMulit.class);
	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		this.mockMvc = webAppContextSetup(this.wac).build();
	}

	@Test
	public void testinsertSelective() throws Exception {
		mockMvc.perform((post("/user/insertSelective.shtml").param("id", "admin111").param("status", "1")
				.param("type", "1").param("loginName", "admin999").param("password", "1"))).andReturn().getResponse();
		// .andExpect(status().isOk())
		// .andDo(print());
	}

	@Test
	public void testSelectByPrimaryKey() throws Exception {
		MockHttpServletResponse response = mockMvc.perform((post("/user/selectByPrimaryKey.shtml?id=0"))).andReturn()
				.getResponse();
		logger.info(LogConstant.LOG_MARK + JSON.toJSONString(response));

	}

	@Test
	public void testShowUser() throws Exception {
		mockMvc.perform((get("/user/0/showUser.shtml"))).andReturn().getResponse();
		// .andExpect(status().isOk()).andDo(print());
	}

	@Test
	public void testGet() throws Exception {
		mockMvc.perform(get("/user/0/showUser.shtml")).andExpect(status().isOk());

	}

	
	 * @Test //有些单元测试你不希望回滚
	 * 
	 * @Rollback(false) public void testInsert() throws Exception {
	 * mockMvc.perform((post("/insertTest"))).andExpect(status().isOk())
	 * .andDo(print()); }
	 
	@Test
	public void testb() throws Exception {
		// mockMvc.perform((get("/spring/testb.do"))).andExpect(status().isOk())
		// .andDo(print());
	}
*/}