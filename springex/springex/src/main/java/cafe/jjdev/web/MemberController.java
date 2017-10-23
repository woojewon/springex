package cafe.jjdev.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cafe.jjdev.web.service.Member;
import cafe.jjdev.web.service.MemberDao;
import cafe.jjdev.web.service.MemberService;

@Controller
public class MemberController {
	@Autowired
	private MemberDao memberDao;
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value="/memberList")
	public String memberList() {
		System.out.println("memberList ��û...");
		// DB list get....
		return "memberList"; 
	}
	
	@RequestMapping(value="/addMember", method = RequestMethod.POST)
	// command��ü�̿��ϴ� ���
	public String addMebmer(MemberRequest memberRequest) { // Member member
		System.out.println(memberRequest);
		memberService.addMember(memberRequest);
		return "redirect:/memberList"; // response.sendRedirct("/memberList")
	}
	
	/* @RequestParam ����
	@RequestMapping(value="/addMember", method = RequestMethod.POST)
	public String addMebmer(@RequestParam(value="memberId") String memberId
							,@RequestParam(value="memberPw") String memberPw
							,@RequestParam(value="memberName") String memberName) {
			System.out.println("memberId:"+memberId);
			System.out.println("memberPw:"+memberPw);
			System.out.println("memberName:"+memberName);
		return "";
	}
	*/
	@RequestMapping(value="/addMember", method = RequestMethod.GET)
	public String addMebmer() {
		return "addMember";
	}
	
	@RequestMapping("/getMember")
	public String getMember(Model model) {
		Member member = memberDao.selectMemberOne(1);
		model.addAttribute("member", member);
		return "getMember";
	}
}
