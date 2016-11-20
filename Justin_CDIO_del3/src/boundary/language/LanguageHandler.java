package boundary.language;

import entity.GameBoard;
import entity.Player;

public class LanguageHandler {

	private static LanguageDefinitions selectedLanguage;

	public LanguageHandler(String language) {
		setLanguage(language);
	}

	public void setLanguage(String language) {
		switch(language) {
		case "Dansk": selectedLanguage = new Dansk(); break;
//		case "English": selectedLanguage = new English(); break;
		default: selectedLanguage = new Dansk();
		}
	}

	/**
	 * Notifies of language change
	 * @return String
	 */
	public String notifyLangChange(){
		return selectedLanguage.notifyLangChange();
	}

	public static String getFieldName(int id, GameBoard gb) {
		return selectedLanguage.getFieldName(id, gb);
	}

	public static String getFieldPrice(int id, GameBoard gb) {
		return selectedLanguage.getFieldPrice(id, gb);
	}
}