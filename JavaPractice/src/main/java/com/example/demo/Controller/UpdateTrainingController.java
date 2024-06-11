package com.example.demo.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.Entity.CharacterEntity;
import com.example.demo.Form.CharacterForm;

@Controller
public class UpdateTrainingController {

	@Autowired
	JdbcTemplate jdbc;

	@RequestMapping("/update_study")
    public String update_study(Model model) {
		
//		charactersテーブルの値を全て取り出すsql文が格納された変数sqlを宣言
		String sql = "SELECT * FROM characters";
		
//		上記のsqlを実行して、取り出されたデータをList型の変数listに格納している
		List<Map<String, Object>> list = jdbc.queryForList(sql);
		
//		データ型がListであるCharacterEntityクラスをインスタンス化した変数characterListを宣言
		List<CharacterEntity> characterList = new ArrayList<CharacterEntity>();
		
//		拡張for文
//		listの中のデータの数だけfor文を回す
//		→1回目は１行目のデータ（heroの行のデータ）について
//		以降、それに続く、、、
		for(Map<String, Object> user : list) {
			
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
		model.addAttribute("characterForm", characterList);
	
    	return "update_study";
    }
	
	@RequestMapping("update_study02/{id}")
	public String getEdit(@PathVariable("id") int id, Model model) {
		
//		charactersテーブルの値を全て取り出すsql文が格納された変数sqlを宣言
		String sql = "SELECT * FROM characters WHERE id = ?";
		
//		上記のsqlを実行して、取り出されたデータをList型の変数listに格納している
		List<Map<String, Object>> list = jdbc.queryForList(sql, id);
		
//		データ型がListであるがCharacterEntityクラスをインスタンス化した変数characterListを宣言		
		List<CharacterEntity> characterList = new ArrayList<CharacterEntity>();
		
//		拡張for文
//		listの中のデータの数だけfor文を回す
//		→1回目は１行目のデータ（heroの行のデータ）について
//		以降、それに続く、、、
		for(Map<String, Object> user : list) {
			
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
		CharacterEntity updateData = new CharacterEntity();
		updateData.setId(characterList.get(0).getId());
		updateData.setName(characterList.get(0).getName());
		updateData.setEnemy_flg(characterList.get(0).getEnemy_flg());
		
//		変数characterListを変数enemyListに格納してHTMLに渡す
		model.addAttribute("characterForm", updateData);
		
		return "update_study02";
	}
	
	@RequestMapping("update_study_answer")
	public String update_study_answer(CharacterForm characterForm, Model model) {
		
		
//		このsql文が間違っている！
//		正しく登録処理が行われるように書き換えてね！

//		↓↓↓↓↓↓↓↓
		
		
		String sql_update = "UPDATE characters VALUES name=?, enemy_flg=? where id = ?";

		
//		↑↑↑↑↑↑↑↑
		
		
		
		
		
//		上記のsql文の「？」の１つ目、２つ目に入力した「名前」と「敵か味方か」、３つ目にidが挿入され実行している
    	jdbc.update(sql_update, characterForm.getName(), characterForm.getEnemy_flg(), characterForm.getId());
    	
//		charactersテーブルの値を全て取り出すsql文が格納された変数sqlを宣言
    	String sql_select = "SELECT * FROM characters";
    	
//		上記のsqlを実行して、取り出されたデータをList型の変数listに格納している
		List<Map<String, Object>> list = jdbc.queryForList(sql_select);
		
//		データ型がListであるがCharacterEntityクラスをインスタンス化した変数characterListを宣言
		List<CharacterEntity> characterList = new ArrayList<CharacterEntity>();
		
//		拡張for文
//		listの中のデータの数だけfor文を回す
//		→1回目は１行目のデータ（heroの行のデータ）について
//		以降、それに続く、、、
		for(Map<String, Object> user : list) {
			
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
		model.addAttribute("characterForm", characterList);		

		return "update_study_answer";
	}
	
	

}