package cafe.jjdev.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cafe.jjdev.web.service.*;
@Controller
public class MemberController {
	@Autowired
	private MemberDao memberDao;
	@RequestMapping(value = "/memberList")
	public String memberList()
	{
		System.out.println("memberList");
		return "memberList";
	}
	
	@RequestMapping(value = "/addMember", method = RequestMethod.POST )
	public String addMember(MemberRequest memberRequest)//커멘드객체로 변수를 받는 방법 한꺼번에
	{
		System.out.println(memberRequest);
		return "redirect:/memberList";//view 존재  response.sendRedirect("/memberList")// redirect/:를 붙여주면 스프링이 리다이렉트한다고 인식
	}
	
	/*@RequestParam 으로 각각 변수를 받는 방법*/
	/*@RequestMapping(value = "/addMember", method = RequestMethod.GET )
	public String addMember(@RequestParam(value = "memberId") String memberId
							,@RequestParam(value = "memberId") String memberPw
							,@RequestParam(value = "memberId") String memberName)
	{
		System.out.println("memberId: " + memberId);
		System.out.println("memberPw: " + memberPw);
		System.out.println("memberName: " + memberName);
		return "";
	}
	*/
	@RequestMapping(value = "/addMember", method = RequestMethod.GET )
	public String addMember()
	{
		return "addMember";
	}
	
	@RequestMapping("/getMember")
	public String getMember(Model model)
	{
		Member member = memberDao.selectMemberOne(1);
		model.addAttribute("member", member);
		return "getMember";
	}
}
