package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.Form.IfStudyForm;

@Controller
public class IfTrainingController {

	@Autowired
	JdbcTemplate jdbc;

	@RequestMapping("/if_study")
	public String if_study(Model model) {

		return "if_study";
	}

	@RequestMapping("if_study_answer")
	public String if_study_answer(@ModelAttribute IfStudyForm ifStudyForm, Model model) {

//		String型の変数if_alertを宣言
		String if_training;

//		画面で入力した値がnumに格納される
		int num = (int) ifStudyForm.getIf_answer();

//		以下のようなコードをif文を使って記述してください

//		変数numが3の倍数の時、if_trainingに"３の倍数です！"を代入する
//		変数numが5の倍数の時、if_trainingに"５の倍数です！"を代入する
//		変数numが３の倍数でも、５の倍数でもない時、
//		if_trainingに"３の倍数でも、５の倍数でもありません！"を代入する

//	  　↓↓↓↓↓↓↓ここから書いてね↓↓↓↓↓↓↓↓↓

		
		
		
		
		
		
		
		
		
		
		
//　　　変数if_training（右）を別の変数if_training（左）に格納してHTMLに渡している
		model.addAttribute("if_training", if_training);
		
		return "if_study_answer";
	}

}