package com.freeappstudiobest.personalassistantclone3.Databases;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


/**
 * Created by apple on 2/23/18.
 */

public class DBHandler extends SQLiteOpenHelper {

    //verdion name of Db
    private static final int DATABASE_VERSION = 2;
    // name of database
    private static final String DATABASE_NAME = "DB_Personal_Information";
    //name of table
    private static final String TABLE_EMAIL = "Email";
    // name of table fields
    private static final String KEY_ID = "id";
    private static final String APP_NAME = "app_name";
    private static final String KEY_USER_NAME = "user_name";
    private static final String KEY_E_POSSWORD = "password";
    private static final String KEY_E_COMMENTS = "comments";

    //name of bank table
    private static final String TABLE_BANK = "BankTable";
    // name of table fields
    private static final String BANK_ID = "id";
    private static final String Account_Tittle = "AccountTittle";
    private static final String Bank_Name = "BankName";
    private static final String Bank_Address = "BankAddress";
    private static final String Account_Type = "AccountType";
    private static final String Branch_Code = "BranchCode";
    private static final String Account_Number = "AccountNumber";
    private static final String SWIFT_BIC = "SWIFTBIC";
    private static final String IBAN = "BankIBAN";
    private static final String Branch_Phone = "BranchPhone";

    //name of bank table
    private static final String TABLE_CARD = "TABLE_CARD";
    // name of table fields
    private static final String CARD_ID = "card_id";
    private static final String Card_Holder_Name = "Card_Holder_Name";
    private static final String Address = "Address";
    private static final String Card_Type = "Card_Type";
    private static final String Card_Number = "Card_Number";
    private static final String Expairy_Date = "Expairy_Date";
    private static final String TPIN_Code = "TPIN_Code";
    private static final String ATM_PIN = "ATM_PIN";
    private static final String CVV_Code = "CVV_Code";
    private static final String Comments = "Comments";

    //name of bank table
    private static final String TABLE_BILL = "TABLE_BILL";
    // name of table fields
    private static final String BILL_ID = "bill_id";
    private static final String Bill_Tittle = "Bill_Tittle";
    private static final String Bill_Name = "Bill_Name";
    private static final String Bill_Address = "Bill_Address";
   // private static final String Bill_Information = "Bill_Information";
   // private static final String Other_Information = "Other_Information";
    private static final String Bill_Comments = "Bill_Comments";

    //name of bank table
    private static final String TABLE_NOTE = "NoteTable";
    // name of table fields
    private static final String NOTE_ID = "NOTE_ID";
    private static final String NOTE_TITLE = "NOTE_TITLE";
    private static final String NOTE_DESCRIPTION = "NOTE_DESCRIPTION";

    // constructor
    public DBHandler(Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
// create table

    @Override
    public void onCreate(SQLiteDatabase db) {
        String abc="create table abc (id integer,name text);";
        String BILL = "CREATE TABLE " + TABLE_BILL + " ( "
                + BILL_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, " + Bill_Tittle + " TEXT, "
                + Bill_Name + " TEXT, "
                + Bill_Address + " TEXT, " +
                Bill_Comments + " TEXT "  +")";
        String CARD = "CREATE TABLE " + TABLE_CARD + " ( "
                + CARD_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, " + Card_Holder_Name + " TEXT, "
                + Address + " TEXT, "
                + Card_Type + " TEXT, " + Card_Number + " TEXT, " + Expairy_Date + " TEXT, " +
                TPIN_Code + " TEXT, " +ATM_PIN + " TEXT, " +CVV_Code + " TEXT, " +
                Comments + " TEXT" +")";
        String CREATION_TABLE = "CREATE TABLE " + TABLE_EMAIL + " ( "
                + "id INTEGER PRIMARY KEY AUTOINCREMENT, " + APP_NAME + " TEXT, "
                + KEY_USER_NAME + " TEXT, "
                + KEY_E_POSSWORD + " TEXT, "
                + KEY_E_COMMENTS + " TEXT" + ")";

        String CREATION_TABLE1 = "CREATE TABLE " + TABLE_BANK + " ( "
                + "id INTEGER PRIMARY KEY AUTOINCREMENT, " + Account_Tittle + " TEXT, "
                + Bank_Name + " TEXT, "
                + Bank_Address + " TEXT, " + Account_Type + " TEXT, " + Branch_Code + " TEXT, " +
                Account_Number + " TEXT, " +SWIFT_BIC + " TEXT, " +IBAN + " TEXT, " +
                Branch_Phone + " TEXT" +")";

        String NOTE = "CREATE TABLE " + TABLE_NOTE + " ( "
                +NOTE_ID+ " INTEGER PRIMARY KEY AUTOINCREMENT, " + NOTE_TITLE + " TEXT, "
                + NOTE_DESCRIPTION + " TEXT"+ ")";
        db.execSQL(CREATION_TABLE);
        db.execSQL(CREATION_TABLE1);
        db.execSQL(NOTE);
        db.execSQL(CARD);
        db.execSQL(BILL);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVesrdion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_EMAIL);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_BANK);
        db.execSQL("DROP TABLE IF EXISTS  "+TABLE_NOTE );
        db.execSQL("DROP TABLE IF EXISTS  "+TABLE_CARD );
        db.execSQL("DROP TABLE IF EXISTS  "+TABLE_BILL );
        this.onCreate(db);
    }
    // method is used to insert BILL vlaues into db table
    public boolean addBillDetials(String account_tittle,String bank_name,String bank_address
            ,String account_number) {
        long result = 0;
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        //get voulue from model classes
        contentValues.put(Bill_Tittle, account_tittle);
        contentValues.put(Bill_Name,bank_name);
        contentValues.put(Bill_Address,bank_address);

       // contentValues.put(Bill_Information, account_type);
        //contentValues.put(Other_Information,branch_code);
        contentValues.put(Bill_Comments,account_number);

        if(contentValues.size() > 0) {
            //inserting new Row
            result=db.insert(TABLE_BILL, null, contentValues);

        }else{


        }
        //long result=db.insert(TABLE_EMAIL,null,contentValues);
        db.close();
        if(result==-1){
            return false;
        }else
            return true;

    }

    // method is used to insert CARD vlaues into db table
    public boolean addCardDetials(String account_tittle,String bank_name,String bank_address
            ,String account_type,String branch_code,String sWIFT_bIC,String account_number
            ,String iBAN,String branch_phone) {
        long result = 0;
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        //get voulue from model classes
        contentValues.put(Card_Holder_Name, account_tittle);
        contentValues.put(Address,bank_name);
        contentValues.put(Card_Type,bank_address);

        contentValues.put(Card_Number, account_type);
        contentValues.put(Expairy_Date,branch_code);
        contentValues.put(TPIN_Code,account_number);

        contentValues.put(ATM_PIN, sWIFT_bIC);
        contentValues.put(CVV_Code,iBAN);
        contentValues.put(Comments,branch_phone);

        if(contentValues.size() > 0) {
            //inserting new Row
            result=db.insert(TABLE_CARD, null, contentValues);

        }else{


        }
        //long result=db.insert(TABLE_EMAIL,null,contentValues);
        db.close();
        if(result==-1){
            return false;
        }else
            return true;

    }
    // method is used to insert NOTE vlaues into db table
    public boolean addNote(String title,String description) {
        long result = 0;
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        //get voulue from model classes
        contentValues.put(NOTE_TITLE, title);
        contentValues.put(NOTE_DESCRIPTION,description);

        if(contentValues.size() > 0) {
            //inserting new Row
            result=  db.insert(TABLE_NOTE, null, contentValues);

        }else{


        }
        //long result=db.insert(TABLE_EMAIL,null,contentValues);
        db.close();
        if(result==-1){
            return false;
        }else
            return true;
    }

    // method is used to insert bank vlaues into db table
    public boolean addBankDetials(String account_tittle,String bank_name,String bank_address
            ,String account_type,String branch_code,String account_number,String sWIFT_bIC
            ,String iBAN,String branch_phone) {
        long result = 0;
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        //get voulue from model classes
        contentValues.put(Account_Tittle, account_tittle);
        contentValues.put(Bank_Name,bank_name);
        contentValues.put(Bank_Address,bank_address);

        contentValues.put(Account_Type, account_type);
        contentValues.put(Branch_Code,branch_code);
        contentValues.put(Account_Number,account_number);

        contentValues.put(SWIFT_BIC, sWIFT_bIC);
        contentValues.put(IBAN,iBAN);
        contentValues.put(Branch_Phone,branch_phone);

        if(contentValues.size() > 0) {
            //inserting new Row
            result=db.insert(TABLE_BANK, null, contentValues);

        }else{


        }
        //long result=db.insert(TABLE_EMAIL,null,contentValues);
        db.close();
        if(result==-1){
            return false;
        }else
            return true;

    }
    // method is used to insert EMAIL vlaues into db table
    public boolean addEmailDetials(String app,String user,String password,String comments) {
        long result = 0;
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        //get voulue from model classes
        contentValues.put(APP_NAME, app);
        contentValues.put(KEY_USER_NAME, user);
        contentValues.put(KEY_E_POSSWORD,password);
        contentValues.put(KEY_E_COMMENTS,comments);

        if(contentValues.size() > 0) {
            //inserting new Row
             result=  db.insert(TABLE_EMAIL, null, contentValues);

        }else{


        }
        //long result=db.insert(TABLE_EMAIL,null,contentValues);
        db.close();
        if(result==-1){
            return false;
        }else
            return true;
}

public Cursor all()
{
    // Select All Query
    String selectQuery = "SELECT  * FROM " + TABLE_EMAIL;
    SQLiteDatabase db = this.getWritableDatabase();
    Cursor cursor = db.rawQuery(selectQuery, null);
return cursor;
}

    public Cursor allbankinfo()
    {
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_BANK;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        return cursor;
    }
    public Cursor allNoteinfo()
    {
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_NOTE;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        return cursor;
    }
    public Cursor allCardinfo()
    {
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_CARD;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        return cursor;
    }
    public Cursor allBillinfo()
    {
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_BILL;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        return cursor;
    }

    /* public List<DbModelEmail> getmailDetial() {
        List<DbModelEmail> userDetials = new ArrayList<DbModelEmail>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_EMAIL;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {

            do {
                DbModelEmail dbModelEmail = new DbModelEmail();
                dbModelEmail.setUserName(cursor.getString(1));
                dbModelEmail.setPassword(cursor.getString(2));
                dbModelEmail.setComment(cursor.getString(3));

//                DbModelEmail contact = new Contact();
//                contact.setID(Integer.parseInt(cursor.getString(0)));
//                contact.setName(cursor.getString(1));
//                contact.setPhoneNumber(cursor.getString(2));
                // Adding contact to list
                userDetials.add(dbModelEmail);
            } while (cursor.moveToNext());
        }

        // return contact list
        return userDetials;
    }*/
    //email update here
    public boolean EmailsUpdate(int id,String app,String user,String password,String comments){

        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(APP_NAME, app);
        contentValues.put(KEY_USER_NAME, user);
        contentValues.put(KEY_E_POSSWORD,password);
        contentValues.put(KEY_E_COMMENTS,comments);

        int i = db.update(TABLE_EMAIL, contentValues, "id ='" +id+"'",null);
        db.close();
        if (i>0)
            return true;
        else
            return false;

    }
    // email delete here
    public boolean EmailDelete(int id){
        SQLiteDatabase db=this.getWritableDatabase();
      int i=  db.delete(TABLE_EMAIL,"id ='"+id+"'",null);
        db.close();
        if (i>0)
            return true;
        else
            return false;
    }
// note update here
    public boolean NoteUpdate(int id,String title,String description){

        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(NOTE_TITLE, title);
        contentValues.put(NOTE_DESCRIPTION,description);

        int i = db.update(TABLE_NOTE, contentValues, "NOTE_ID ='" +id+"'",null);
        db.close();
        if (i>0)
            return true;
        else
            return false;

    }
    // note delete here
    public boolean NoteDelete(int id){
        SQLiteDatabase db=this.getWritableDatabase();
        int i=  db.delete(TABLE_NOTE,"NOTE_ID ='"+id+"'",null);
        db.close();
        if (i>0)
            return true;
        else
            return false;
    }
    // bill update here
    public boolean BillUpdate(int id,String account_tittle,String bank_name,String bank_address
            ,String account_number){

        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(Bill_Tittle, account_tittle);
        contentValues.put(Bill_Name,bank_name);
        contentValues.put(Bill_Address,bank_address);

       // contentValues.put(Bill_Information, account_type);
        //contentValues.put(Other_Information,branch_code);
        contentValues.put(Bill_Comments,account_number);


        int i = db.update(TABLE_BILL, contentValues, "bill_id ='" +id+"'",null);
        db.close();
        if (i>0)
            return true;
        else
            return false;

    }
    // bill delete here
    public boolean BillDelete(int id){
        SQLiteDatabase db=this.getWritableDatabase();
        int i=  db.delete(TABLE_BILL,"bill_id ='"+id+"'",null);
        db.close();
        if (i>0)
            return true;
        else
            return false;
    }
    // bank update here
    public boolean BankUpdate(int id,String account_tittle,String bank_name,String bank_address
            ,String account_type,String branch_code,String account_number,String sWIFT_bIC
            ,String iBAN,String branch_phone){

        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(Account_Tittle, account_tittle);
        contentValues.put(Bank_Name,bank_name);
        contentValues.put(Bank_Address,bank_address);

        contentValues.put(Account_Type, account_type);
        contentValues.put(Branch_Code,branch_code);
        contentValues.put(Account_Number,account_number);

        contentValues.put(SWIFT_BIC, sWIFT_bIC);
        contentValues.put(IBAN,iBAN);
        contentValues.put(Branch_Phone,branch_phone);


        int i = db.update(TABLE_BANK, contentValues, "id ='" +id+"'",null);
        db.close();
        if (i>0)
            return true;
        else
            return false;

    }
    // bank delete here
    public boolean BankDelete(int id){
        SQLiteDatabase db=this.getWritableDatabase();
        int i=  db.delete(TABLE_BANK,"id ='"+id+"'",null);
        db.close();
        if (i>0)
            return true;
        else
            return false;
    }
    // card update here
    public boolean CardUpdate(int id,String account_tittle,String bank_name,String bank_address
            ,String account_type,String branch_code,String sWIFT_bIC,String account_number
            ,String iBAN,String branch_phone){

        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(Card_Holder_Name, account_tittle);
        contentValues.put(Address,bank_name);
        contentValues.put(Card_Type,bank_address);

        contentValues.put(Card_Number, account_type);
        contentValues.put(Expairy_Date,branch_code);
        contentValues.put(TPIN_Code,account_number);

        contentValues.put(ATM_PIN, sWIFT_bIC);
        contentValues.put(CVV_Code,iBAN);
        contentValues.put(Comments,branch_phone);

        int i = db.update(TABLE_CARD, contentValues, "card_id ='" +id+"'",null);
        db.close();
        if (i>0)
            return true;
        else
            return false;

    }
    // card delete here
    public boolean CardDelete(int id){
        SQLiteDatabase db=this.getWritableDatabase();
        int i=  db.delete(TABLE_CARD,"card_id ='"+id+"'",null);
        db.close();
        if (i>0)
            return true;
        else
            return false;
    }
}
