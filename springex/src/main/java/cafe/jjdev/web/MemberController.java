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
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value = "/memberList")
	public String memberList()
	{
		System.out.println("memberList ��û...");
		return "memberList";
	}
	
	@RequestMapping(value = "/addMember", method = RequestMethod.POST )
	public String addMember(MemberRequest memberRequest)//Ŀ��尴ü�� ������ �޴� ��� �Ѳ�����
	{
		System.out.println(memberRequest);
		memberDao.insertMember(member);
		return "redirect:/memberList";//view ����  response.sendRedirect("/memberList")// redirect/:�� �ٿ��ָ� �������� �����̷�Ʈ�Ѵٰ� �ν�
	}
	
	/*@RequestParam ���� ���� ������ �޴� ���*/
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
