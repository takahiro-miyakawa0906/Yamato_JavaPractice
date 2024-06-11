package com.example.demo.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.Form.ForStudyForm;

@Controller
public class ForTrainingController {

	@Autowired
	JdbcTemplate jdbc;

	@RequestMapping("/for_study")
	public String for_study(Model model) {

		return "for_study";
	}

	@RequestMapping("for_study_answer")
	public String for_study_answer(@ModelAttribute ForStudyForm forStudyForm, Model model) {


//	　　数字を入れるためのList（複数のデータを入れるための箱）、num_listを用意した
		List<Integer> num_list = new ArrayList<>();

//		画面で入力した値（自然数）をnumに格納した
		int num = (int) forStudyForm.getFor_answer();

		
//		以下のようなコードをfor文を使って記述してください
		
//		1からnumまで1ずつ、num_listの中に値を入れたい
//		listに値を入れたい時は、addメソッドを使うよ！
//		例）数字の2をnum_listの中に入れたい時は、
//					num_list.add(2);
//		という風に書けば、num_listの末尾に2が入るよ！
		
		
		
//		↓↓↓↓↓↓↓ここから書いてね↓↓↓↓↓↓↓↓↓
		

		
		
		
		
		
		
		
		
		
//　　　変数num_listを変数for_trainingに格納して、HTMLに渡している
		model.addAttribute("for_training", num_list);
		
		return "for_study_answer";
	}
}