package xyz.wingio.plugins.morehighlight;

import androidx.core.graphics.ColorUtils;
import android.graphics.Color;
import com.discord.simpleast.core.node.Node;
import com.discord.utilities.textprocessing.*;

import android.text.SpannableStringBuilder;
import android.text.style.*;

public class ListBulletNode<MessageRenderContext> extends Node<MessageRenderContext> {

  public ListBulletNode(){
    super();
  }

  @Override
  public void render(SpannableStringBuilder builder, MessageRenderContext renderContext) {
    int startIndex = builder.length();

    for (Node n : getChildren()) {
      n.render(builder, renderContext);
    }
    builder.setSpan(new BulletSpan(18, Color.parseColor("#6e7B7F"), 7), startIndex, builder.length(), SpannableStringBuilder.SPAN_EXCLUSIVE_EXCLUSIVE);
  }
}