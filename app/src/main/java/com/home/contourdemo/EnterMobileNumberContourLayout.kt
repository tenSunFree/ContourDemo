package com.home.contourdemo

import android.annotation.SuppressLint
import android.graphics.Paint
import android.text.Editable
import android.text.TextWatcher
import android.util.TypedValue
import android.view.Gravity
import android.view.View
import android.widget.*
import com.squareup.contour.ContourLayout
import com.squareup.contour.YInt
import kotlin.contracts.ExperimentalContracts

@SuppressLint("ViewConstructor")
@ExperimentalContracts
class EnterMobileNumberContourLayout(context: MainActivity) : ContourLayout(context) {

    private val titleTextView =
        TextView(context).apply {
            text = "手機認證"
            setTextColor(resources.getColor(R.color.color_FF000000))
            setTextSize(TypedValue.COMPLEX_UNIT_DIP, 18f)
            setBackgroundColor(resources.getColor(R.color.color_FFF9F9F9))
            gravity = Gravity.CENTER
            height = 52.dip
        }

    private val previousPageImageView =
        ImageView(context).apply {
            setBackgroundResource(R.drawable.icon_previous_page)
        }

    private val shadowView =
        View(context).apply {
            setBackgroundColor(resources.getColor(R.color.color_FFE4E2E5))
        }

    private val getBonusTextView =
        TextView(context).apply {
            text = "完成認證後將可不定期獲得贈點優惠喔！"
            setTextColor(resources.getColor(R.color.color_FF005BD6))
            setTextSize(TypedValue.COMPLEX_UNIT_DIP, 18f)
            gravity = Gravity.CENTER
        }

    private val mobileNumberEditText =
        EditText(context).apply {
            hint = "請輸入手機號碼"
            isFocusable = true
            isFocusableInTouchMode = true
            requestFocus()
            setTextSize(TypedValue.COMPLEX_UNIT_DIP, 17f)
            addTextChangedListener(object : TextWatcher {
                override fun afterTextChanged(p0: Editable?) {}
                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
                override fun onTextChanged(
                    charSequence: CharSequence?,
                    start: Int,
                    before: Int,
                    count: Int
                ) {
                    verifyNumberButton.isEnabled = charSequence!!.length >= 10
                }
            })
        }

    private val serviceTermsTextView =
        TextView(context).apply {
            text = "服務條款及隱私權政策"
            setTextColor(resources.getColor(R.color.color_FF777777))
            setTextSize(TypedValue.COMPLEX_UNIT_DIP, 14f)
            paint.flags = Paint.UNDERLINE_TEXT_FLAG // 下劃線
        }

    private val verifyNumberButton =
        Button(context).apply {
            text = "同意條款並驗證號碼"
            setTextColor(resources.getColor(R.color.color_FFFFFFFF))
            setTextSize(TypedValue.COMPLEX_UNIT_DIP, 14f)
            isEnabled = false
            setBackgroundResource(R.drawable.background_verify_number_button)
            setOnClickListener {
                Toast.makeText(context, "click verifyNumberButton", Toast.LENGTH_SHORT).show()
            }
        }

    init {
        setBackgroundColor(resources.getColor(R.color.color_FFFFFFFF))
    }

    override fun onInitializeLayout() {
        titleTextView.applyLayout(
            leftTo { parent.left() }.rightTo { parent.right() },
            topTo { parent.top() }
        )
        previousPageImageView.applyLayout(
            leftTo { parent.left() + 16.dip }.widthOf { titleTextView.height().toX() - 36.dip },
            topTo { titleTextView.top() + 14.dip }.bottomTo { titleTextView.bottom() - 14.dip }
        )
        shadowView.applyLayout(
            leftTo { parent.left() }.rightTo { parent.right() },
            topTo { titleTextView.bottom() }.heightOf { YInt(2) }
        )
        getBonusTextView.applyLayout(
            leftTo { parent.left() + 16.dip }.rightTo { parent.right() - 16.dip },
            topTo { shadowView.bottom() + 32.dip }
        )
        mobileNumberEditText.applyLayout(
            leftTo { parent.left() + 16.dip }.rightTo { parent.right() - 16.dip },
            topTo { getBonusTextView.bottom() + 42.dip }
        )
        serviceTermsTextView.applyLayout(
            leftTo { parent.left() + 16.dip },
            topTo { mobileNumberEditText.bottom() + 16.dip }
        )
        verifyNumberButton.applyLayout(
            leftTo { parent.left() + 18.dip }.rightTo { parent.right() - 18.dip },
            topTo { serviceTermsTextView.bottom() + 32.dip }
        )
    }
}