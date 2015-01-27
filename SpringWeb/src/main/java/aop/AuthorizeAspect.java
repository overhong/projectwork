package aop;

import java.lang.reflect.Method;//메서드는 요걸로 임포트 한다

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import pbean.UserInfo;

@Aspect
public class AuthorizeAspect {
	//@RequestMapping이 붙어있는 모든 메서드들에 대해 포인트컷을 해보자
	@Pointcut("execution(@org.springframework.web.bind.annotation.RequestMapping * *(..))")//포인트컷 하나 생성
	public void handlerMethod(){}
	
	@Before("handlerMethod()")
	public void interceptMethod(JoinPoint jp) throws Exception{
		MethodSignature ms = (MethodSignature)jp.getSignature();
		
		Method me = ms.getMethod();
		
		//메서드에서 해당 어노테이션 취득(해당 어노테이션이 있는지 검색)
		Authorize au = me.getAnnotation(Authorize.class);
		
		if(au!=null){
			//권한 체크
			RequestAttributes ra = RequestContextHolder.getRequestAttributes();
			UserInfo loginUser = (UserInfo)ra.getAttribute("user", RequestAttributes.SCOPE_SESSION);
			/*RequestContextHolder 클래스는 ThreadLocal를 사용해서 현재 쓰레드에 RequestAttributes 
			인스턴스를 바인딩 해두었다가 요청을 하면 이 인스턴스를 돌려주는 역할을 합니다
			getRequestAttributes()는 RequestAttributes가 없으면 널을 반환*/


		
			if(loginUser==null){
				//로그인 하지 않고 접근한 경우 처리
				System.out.println("접근만 했음");
				System.out.println("로그인 하십시오");
				throw new InvalidLoginException();//예외 처리를 스프링이 처리 하도록 하겠다.
					//로그인 안한채로 http://localhost/SpringWeb/boardList.htmlt실행하면 500에러 뜸
				} else if(loginUser.getRole().equals("admin")) {
					ra.setAttribute("adminMessage", "관리자모드",RequestAttributes.SCOPE_SESSION );
			}else {
				//로그인 후 접근한 경우 처리
				ra.setAttribute("adminMessage", "", RequestAttributes.SCOPE_SESSION);
				System.out.println("로그인 감사합니다.");
			}
		}
	
	}
}








