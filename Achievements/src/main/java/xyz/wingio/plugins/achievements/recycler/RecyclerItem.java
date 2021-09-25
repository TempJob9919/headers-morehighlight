package xyz.wingio.plugins.achievements.recycler;

import android.content.Context;
import android.view.*;
import android.widget.*;
import android.graphics.drawable.*;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.content.ContextCompat;

import com.discord.utilities.color.ColorCompat;

import com.aliucord.Utils;
import com.aliucord.Constants;
import com.aliucord.utils.*;
import com.aliucord.views.Button;
import com.aliucord.views.ToolbarButton;

import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.card.MaterialCardView;

import com.lytefast.flexinput.R;

public class RecyclerItem extends LinearLayout {
    public final TextView name;

    public RecyclerItem(Context ctx) {
        super(ctx);
        setOrientation(LinearLayout.HORIZONTAL);
        setGravity(Gravity.CENTER_VERTICAL);
        setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
        name = new TextView(ctx, null, 0, R.h.UiKit_Settings_Item_Icon);
        name.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));

        addView(name);
    }
}