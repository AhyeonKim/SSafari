package com.ssafy.edu.vue.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.edu.vue.dto.Member;
import com.ssafy.edu.vue.dto.Code;
import com.ssafy.edu.vue.help.BoolResult;
import com.ssafy.edu.vue.service.ICodeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

//http://localhost:8197/humans/swagger-ui.html
@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/api")
@Api(value = "SSAFY", description = "A5 Resouces Management 2020")
public class CodeController {

	public static final Logger logger = LoggerFactory.getLogger(CodeController.class);

	@Autowired
	private ICodeService codeservice;
	
	@ApiOperation(value = "code 전체 보기", response = List.class)
	@RequestMapping(value = "/codes", method = RequestMethod.GET)
	public ResponseEntity<List<Code>> getCodes(HttpServletRequest rs) throws Exception {
		logger.info("1-------------getCodes-----------------------------" + new Date());
		int memberid = 0;
		if(rs.getAttribute("loginMember")!=null) {
			Member member = (Member) rs.getAttribute("loginMember");
			memberid = member.getMemberid();
		}
		List<Code> codes = codeservice.getCodes(memberid);
		if (codes == null) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Code>>(codes, HttpStatus.OK);
	}
	
	@ApiOperation(value = "code 상세 보기", response = List.class)
	@RequestMapping(value = "/code/{id}", method = RequestMethod.GET)
	public ResponseEntity<Code> getCode(@PathVariable int id,HttpServletRequest rs) throws Exception {
		logger.info("1-------------getCode-----------------------------" + new Date());
		Code code = codeservice.getCode(id);
		if (code == null) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Code>(code, HttpStatus.OK);
	}
	
	@ApiOperation(value = "code 추가", response = List.class)
	@RequestMapping(value = "/code", method = RequestMethod.POST)
	public ResponseEntity<BoolResult> addCode(@RequestBody Code code) throws Exception {
		logger.info("1-------------addCode-----------------------------" + new Date());
		codeservice.addCode(code);
		BoolResult nr=new BoolResult();
   		nr.setName("addCode");
   		nr.setState("succ");
		return new ResponseEntity<BoolResult>(nr, HttpStatus.OK);
	}
	
	@ApiOperation(value = "code 수정", response = BoolResult.class)
	@RequestMapping(value = "/code", method = RequestMethod.PUT)
	public ResponseEntity<BoolResult> updateCode(@RequestBody Code code) throws Exception {
		logger.info("1-------------updateCode-----------------------------" + new Date());
		codeservice.updateCode(code);
		BoolResult nr=new BoolResult();
   		nr.setName("updateCode");
   		nr.setState("succ");
		return new ResponseEntity<BoolResult>(nr, HttpStatus.OK);
	}
	
	@ApiOperation(value = "code 삭제", response = BoolResult.class)
	@RequestMapping(value = "/code/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<BoolResult> deleteCode(@PathVariable int id) throws Exception {
		logger.info("1-------------deleteCode-----------------------------" + new Date());
		codeservice.deleteCode(id);
		BoolResult nr=new BoolResult();
   		nr.setName("deleteCode");
   		nr.setState("succ");
		return new ResponseEntity<BoolResult>(nr, HttpStatus.OK);
	}
}
