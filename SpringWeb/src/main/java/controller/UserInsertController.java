package controller;

import java.util.List;

import javax.validation.Valid;

import logic.UserLogic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pbean.UserInfo;
import vbean.VUserInfo;

@Controller
public class UserInsertController {
   @Autowired
   private UserLogic userLogic;
   
   @RequestMapping(value="/signUp.html", 
         method=RequestMethod.GET)
   public String signUp(Model model) {
      model.addAttribute("signUpForm", new VUserInfo());
      return "signUp";
   }
   
   @RequestMapping(value="/signUp.html", 
         method=RequestMethod.POST)
   public String onSubmit(
         //모델의 이름은 모델명의 첫번째 알파벳을 소문자로 한것이 디폴트
         @Valid @ModelAttribute("signUpForm") VUserInfo signUpForm,
         BindingResult result, Model model)
         {
            //일반 에러가 발생하면 돌아간다
            if (result.hasErrors()) {
               //바인딩 에러가 발생시에는 별도로 폼을 모델에 담을 필요 없음
               return "signUp";
            }
            
            //사용자 처리 에러(아이디 중복 체크)
            List<UserInfo> list =
                  this.userLogic.searchByIdAjax(signUpForm.getUserid());
            if (list.size() > 0) {
               result.rejectValue("userid", 
                        "userid.dup",null, "아이디가 중복되었습니다" );
               model.addAttribute("signUpForm", signUpForm);
               return "signUp";
            }
            
            //회원가입 처리
            this.userLogic.addUser(signUpForm);
            return "redirect:/login.html";
         }
}

















