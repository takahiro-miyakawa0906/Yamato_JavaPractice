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

@Controller
public class DeleteTrainingController {

	@Autowired
	JdbcTemplate jdbc;

	@RequestMapping("/delete_study")
    public String delete_study(Model model) {
		
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
		
	
    	return "delete_study";
    }
	
	@RequestMapping("delete_study_answer/{id}")
	public String getEdit(@PathVariable("id") int id, Model model) {
		
		
		
//		このsql文が間違っている！
//		正しく登録処理が行われるように書き換えてね！

//		↓↓↓↓↓↓↓↓
		
		
		String sql_delete = "DELETE FROM characters ON id = ?";

		
//		↑↑↑↑↑↑↑↑
		
		
		
//		上記のsql文の「？」にidを挿入してsql文を実行している
		jdbc.update(sql_delete, id);
		
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
		
		return "delete_study_answer";
	}
}