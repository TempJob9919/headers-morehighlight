package xyz.wingio.plugins.morehighlight;

import android.content.Context;
import android.graphics.Color;

import com.aliucord.PluginManager;
import com.discord.simpleast.core.parser.ParseSpec;
import com.discord.simpleast.core.parser.Parser;
import com.discord.simpleast.core.node.Node;
import com.discord.simpleast.core.parser.Rule;
import com.discord.utilities.textprocessing.*;
import android.text.style.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class ListBulletRule extends Rule.BlockRule<MessageRenderContext, ListBulletNode<MessageRenderContext>, MessageParseState> {

    public ListBulletRule(Pattern pattern) {
        super(pattern);
    }

    @Override
    public ParseSpec<MessageRenderContext, MessageParseState> parse(Matcher matcher, Parser<MessageRenderContext, ? super ListBulletNode<MessageRenderContext>, MessageParseState> parser, MessageParseState s) {
        try {
            ListBulletNode textNode = new ListBulletNode();
            return new ParseSpec<>(textNode, s, matcher.start(1), matcher.end(1));
        } catch (Exception e) {
            return new ParseSpec<>(new TextNode(matcher.group(0)), s);
        }
    }
}