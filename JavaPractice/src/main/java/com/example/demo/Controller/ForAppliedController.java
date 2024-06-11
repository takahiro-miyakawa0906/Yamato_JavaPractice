package com.example.demo.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.Entity.CharacterEntity;

@Controller
public class ForAppliedController {

	@Autowired
	JdbcTemplate jdbc;

	@RequestMapping("/for_applied")
    public String for_applied(Model model) {
    	
    	return "for_applied";
    }
	
	@RequestMapping("for_applied_answer")
	public String for_applied_answer(Model model) {

//		charactersテーブルのデータをすべて取り出すsql文を変数sqlに格納した
		String sql = "SELECT * FROM characters";
		
//		変数sqlに格納したsql文を実行してlistの中に格納した
		List<Map<String, Object>> list = jdbc.queryForList(sql);
		
//		データ型がCharacterEntityのListである、characterListを宣言した
		List<CharacterEntity> characterList = new ArrayList<CharacterEntity>();
		
//		拡張for文
//		listの中のデータの数だけfor文を回す
//		→1回目は１行目のデータ（heroの行のデータ）について
//		以降、それに続く、、、
		for(Map<String, Object> user : 「blank」) {
			
//			CharacterEntityクラスを変数characterEntityでインスタンス化
			CharacterEntity characterEntity = new CharacterEntity();
			
//			変数characterEntityのidの値をカッコ内の値でセットする
			characterEntity.setId(Integer.parseInt(user.get("id").toString()));
			characterEntity.setName((String) user.get("name"));		
			characterEntity.setEnemy_flg((int) user.get("enemy_flg"));
			if(user.get("enemy_flg").equals(0)) {
				characterEntity.setEnemy_or_team("味方");
			}else{
				characterEntity.setEnemy_or_team("敵");
			}
//			characterListにcharacterEntityを追加する
			characterList.add(characterEntity);
		}
//		変数characterListを変数characterListに格納してHTMLに渡す
		model.addAttribute("characterList", characterList);
		
		return "for_applied_answer";
	}
}