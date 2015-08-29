package com.quranicwords;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class ModifyDatabase {

	private static final String DB_PATH = "/data/data/com.quranicwords/databases/";
	private static final String DB_NAME = "Quran_Vocabulary.db";
	private static int DB_VERSION = 0;

	public static String TABLE_TOKENS = "tokens";
	public static String COLUMN_ID = "_id";
	public static String COLUMN_ARABIC_FORM = "arabic_form";
	public static String COLUMN_CHAPTER = "chapter";
	public static String COLUMN_VERSE = "verse";
	public static String COLUMN_TOKEN = "token";
	public static String COLUMN_FREQUENCY = "frequency";
	public static String COLUMN_TRANSLITERATION = "transliteration";
	public static String COLUMN_ENGLISH_FORM = "english_form";
	public static String COLUMN_ENGLISH_ROOT = "english_root";
	public static String COLUMN_ARABIC_ROOT = "arabic_root";
	public static String COLUMN_BOOKMARK = "bookmark";

	public static String TABLE_CHAPTERS = "chapters";
	public static String COLUMN_CHAPTER_NAME = "chapter_name";

	public static String TABLE_QURAN_SIMPLE_ENHANCED = "quran_simple_enhanced";
	public static String COLUMN_TEXT = "text";

	public static String TABLE_EN_SAHIH = "en_sahih";
	
	public static String TABLE_FREQUENT_WORDS_REFERENCE = "frequent_words_reference";
	public static String COLUMN_F_ID = "_id";
	public static String COLUMN_REF_ID = "ref_id";
	public static String COLUMN_RESULT = "result";

	public ModifyDatabase(int DB_VERSION) {
		this.DB_VERSION = DB_VERSION;
	}

	public static void createDatabaseIfNotExists(Context context)
			throws IOException {
		boolean createDb = false;

		File dbDir = new File(DB_PATH);
		File dbFile = new File(DB_PATH + DB_NAME);
		if (!dbDir.exists()) {
			dbDir.mkdir();
			createDb = true;
		} else if (!dbFile.exists()) {
			createDb = true;
		} else {
			// Check that we have the latest version of the db
			boolean doUpgrade = false;

			int CURRENT_DB_VERSION = context.getResources()
					.openRawResource(R.raw.db_version).read() - 48;
			System.out.println(CURRENT_DB_VERSION + " " + DB_VERSION);

			if (CURRENT_DB_VERSION < DB_VERSION) {
				doUpgrade = true;
				System.out.println("Need Upgrade from " + CURRENT_DB_VERSION
						+ " to " + DB_VERSION);
			}

			if (doUpgrade) {
				dbFile.delete();
				createDb = true;
			}
		}

		if (createDb) {
			// Open your local db as the input stream
			InputStream myInput = context.getAssets().open(DB_NAME);

			// Open the empty db as the output stream
			OutputStream myOutput = new FileOutputStream(dbFile);

			// transfer bytes from the inputfile to the outputfile
			byte[] buffer = new byte[1024];
			int length;
			while ((length = myInput.read(buffer)) > 0) {
				myOutput.write(buffer, 0, length);
			}

			// Close the streams
			myOutput.flush();
			myOutput.close();
			myInput.close();
		}
	}

	public static SQLiteDatabase getStaticDb() {
		return SQLiteDatabase.openDatabase(DB_PATH + DB_NAME, null,
				SQLiteDatabase.OPEN_READWRITE);
	}

	public static Cursor getBasic() {
		String[] columns = { COLUMN_ID, COLUMN_ARABIC_FORM,
				COLUMN_ENGLISH_FORM, COLUMN_BOOKMARK };
		return getStaticDb().query(TABLE_TOKENS, columns, null, null, null,
				null, null);
	}

	public static Cursor getDetail(int _id) {
		String[] columns_ = { COLUMN_ID, COLUMN_ARABIC_FORM, COLUMN_CHAPTER,
				COLUMN_VERSE, COLUMN_FREQUENCY, COLUMN_TRANSLITERATION,
				COLUMN_ENGLISH_FORM, COLUMN_ENGLISH_ROOT, COLUMN_ARABIC_ROOT,
				COLUMN_BOOKMARK };
		return getStaticDb().query(TABLE_TOKENS, columns_, "_id =? ",
				new String[] { String.valueOf(_id + 1) }, null, null, null);
	}

	public static ArrayList<String> getText(int chapter, int verse) {
		ArrayList<String> location = new ArrayList<String>();
		String[] columns_ = { COLUMN_CHAPTER_NAME };
		Cursor temp = getStaticDb().query(TABLE_CHAPTERS, columns_, "_id =?",
				new String[] { String.valueOf(chapter) }, null, null, null);
		temp.moveToFirst();
		location.add(temp.getString(temp.getColumnIndex(COLUMN_CHAPTER_NAME)));

		String[] columns__ = { COLUMN_TEXT };
		temp = getStaticDb()
				.query(TABLE_QURAN_SIMPLE_ENHANCED,
						columns__,
						"chapter =? AND verse =?",
						new String[] { String.valueOf(chapter),
								String.valueOf(verse) }, null, null, null);
		temp.moveToFirst();
		location.add(temp.getString(temp.getColumnIndex(COLUMN_TEXT)));
		//
		String[] columns___ = { COLUMN_TEXT };
		temp = getStaticDb()
				.query(TABLE_EN_SAHIH,
						columns___,
						"chapter =? AND verse =?",
						new String[] { String.valueOf(chapter),
								String.valueOf(verse) }, null, null, null);
		temp.moveToFirst();
		location.add(temp.getString(temp.getColumnIndex(COLUMN_TEXT)));

		return location;
	}
	
	public static Cursor getResult(){
		String[] columns = { COLUMN_F_ID, COLUMN_REF_ID,
				COLUMN_RESULT };
		return getStaticDb().query(TABLE_FREQUENT_WORDS_REFERENCE, columns, null, null, null,
				null, null);
	}
	
	public static Cursor getSet(ArrayList<Integer> index)
	{
		String[] index_values = new String[index.size()];
		for(int i = 0; i < index.size(); i++)
		{
			index_values[i] = String.valueOf(index.get(i));
		}
		
		String[] columns = { COLUMN_ID, COLUMN_ARABIC_FORM,
				COLUMN_ARABIC_ROOT, COLUMN_ENGLISH_FORM };
		return getStaticDb().query(TABLE_TOKENS, columns, "_id in (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)", index_values, null, null, COLUMN_ID.concat(" ASC"), null);
	}
}
