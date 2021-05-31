package br.com.avaty.gastodeviagens

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText

abstract class ValidacaoEditText (private val edit: EditText) : TextWatcher {

    abstract fun validate(edit: EditText?, text: String?)


    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
    }

    override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
    }

    override fun afterTextChanged(p0: Editable?) {
        val text: String = edit.getText().toString()
        validate(edit, text)
    }
}