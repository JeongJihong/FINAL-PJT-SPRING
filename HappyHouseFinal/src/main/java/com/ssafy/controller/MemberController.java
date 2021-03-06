package com.ssafy.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.dto.MemberDTO;
import com.ssafy.service.MemberService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@CrossOrigin("*")
@RestController
@Api("HappyHouse Member 컨트롤러 API V1")
@RequestMapping("/mem")
public class MemberController {

	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	private MemberService memberService;

	@ApiOperation(value = "비밀번호를 찾는다.", response = Map.class)
	@PostMapping(value = "/findpassword")
	public ResponseEntity<Map<String, String>> findPassword(@RequestBody MemberDTO memberDTO) {
		logger.debug("findpassword");
		Map<String, String> mapRtn = new HashMap<String, String>();
		
		MemberDTO result = memberService.findPassword(memberDTO);
		
		if(result == null) {
			mapRtn.put("msg", "일치하는 정보를 찾을 수 없습니다.");
			return new ResponseEntity<>(mapRtn, HttpStatus.OK);
			
		} else {
			mapRtn.put("msg", "비밀번호는 " + result.getPassword() + " 입니다.");
			return new ResponseEntity<>(mapRtn, HttpStatus.OK);
		}
	}

	@ApiOperation(value = "로그인 한다.", response = Map.class)
	@PostMapping(value = "/login")
	public ResponseEntity<Map<String, String>> login(@RequestBody Map<String, String> map) {
		logger.debug("login");
		logger.debug(map.get("id"));
		logger.debug(map.get("password"));
		Map<String, String> mapRtn = new HashMap<String, String>();
		
		MemberDTO memberDTO = memberService.login(map);
		if(memberDTO != null) {
			mapRtn.put("id", memberDTO.getId());
			mapRtn.put("password", memberDTO.getPassword());
			mapRtn.put("name", memberDTO.getName());
			mapRtn.put("email", memberDTO.getEmail());
			mapRtn.put("address", memberDTO.getAddress());
			
			logger.info("로그인 성공");
			return new ResponseEntity<>(mapRtn, HttpStatus.OK);
			
		} else {
			logger.info("로그인 실패");
			mapRtn.put("id", "");
			mapRtn.put("msg", "아이디 또는 패스워드가 일치하지 않습니다.");
			return new ResponseEntity<>(mapRtn, HttpStatus.OK);
		}

	}

	@ApiOperation(value = "로그아웃 한다.", response = String.class)
	@GetMapping(value = "/logout")
	public ResponseEntity<String> logout(HttpSession session) {
		logger.debug("logout");
		session.invalidate();
		return new ResponseEntity<>("success", HttpStatus.OK);
	}

	@ApiOperation(value = "회원정보를 추가한다.", response = Map.class)
	@PostMapping(value = "/insert")
	public ResponseEntity<Map<String, String>> insertMember(@RequestBody MemberDTO memberDTO) {
		logger.debug("insert member");
		Map<String, String> mapRtn = new HashMap<String, String>();
		
		if(memberService.searchId(memberDTO.getId()) == null) {
			memberService.insertMember(memberDTO);
			mapRtn.put("msg", "");
			
		} else {
			mapRtn.put("msg", "이미 등록된 회원입니다.");
			
		}
		
		return new ResponseEntity<>(mapRtn, HttpStatus.OK);
	}

	@ApiOperation(value = "회원정보를 수정한다.", response = String.class)
	@PutMapping(value = "/update")
	public ResponseEntity<String> updateMember(@RequestBody MemberDTO memberDTO) {
		logger.debug("update member");
		memberService.update(memberDTO);
		
		return new ResponseEntity<>("success", HttpStatus.OK);
	}

	@ApiOperation(value = "회원정보를 삭제한다.", response = Map.class)
	@DeleteMapping(value = "/delete")
	public ResponseEntity<String> deleteMember(Model model, HttpSession session) {
		logger.debug("delete member");
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId((String)session.getAttribute("id"));
		memberService.delete(memberDTO);
		model.addAttribute("msg", "회원탈퇴가 완료되었습니다.");
		
		session.invalidate();

		return new ResponseEntity<String>("success", HttpStatus.OK);
	}
}
