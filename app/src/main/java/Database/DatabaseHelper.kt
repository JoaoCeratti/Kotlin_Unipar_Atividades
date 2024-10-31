package Database

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.ex1.entidade.Item

class DatabaseHelper(context : Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, VERSION_DATABASE) {

    companion object {
        private const val DATABASE_NAME = "COMPRAS_UNIPAR.db"
        private const val VERSION_DATABASE = 2
        private const val TABLE_NAME = "item"

        private const val COLUMN_ID = "id"
        private const val COLUMN_QUANTITY = "description"
        private const val COLUMN_DESCRIPTION = "quantity"


    }

    override fun onCreate(db: SQLiteDatabase) {

        val createTable = ("CREATE TABLE ${TABLE_NAME} (" +
                "${COLUMN_ID} INTEGER PRIMARY KEY AUTOINCREMENT," +
                "${COLUMN_DESCRIPTION} TEXT," +
                "${COLUMN_QUANTITY} INTEGER )" )
        db.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS ${TABLE_NAME}")
        onCreate(db)
    }

    fun saveItem(description: String,quantity: Int){
        val db = this.writableDatabase

        val values = ContentValues().apply {
            put(COLUMN_DESCRIPTION, description)
            put(COLUMN_QUANTITY, quantity)
        }

        db.insert(TABLE_NAME, null, values)
        db.close()
    }

    fun getListItems(): List<Item>{

        val itemList = mutableListOf<Item>()
        val querySelect = "SELECT * FROM ${TABLE_NAME}"
        val db = this.readableDatabase

        val cursor = db.rawQuery(querySelect, null)

        if(cursor.moveToFirst()) {
            do {

                val id = cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_ID))
                val description = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_DESCRIPTION))
                val quantity = cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_QUANTITY))

                val item = Item(id, description, quantity)

                itemList.add(item)

            } while (cursor.moveToNext())
        }
            cursor.close()
            db.close()
            return itemList

    }

    fun deleteItem(id : Int){
        val db = this.writableDatabase
        db.delete(TABLE_NAME,
            " ${COLUMN_ID} = ? ", arrayOf(id.toString()))

        db.close()

    }

    fun updateItem(item: Item){
        val db = this.writableDatabase


        val values = ContentValues().apply {
            put(COLUMN_DESCRIPTION, item.description)
            put(COLUMN_QUANTITY, item.quantity)
        }
        db.update(TABLE_NAME, values, " ${COLUMN_ID} = ?", arrayOf(item.id.toString()))
    }
}
