package xyz.wingio.plugins.morehighlight;

import android.content.Context;

import com.discord.simpleast.core.parser.ParseSpec;
import com.discord.simpleast.core.parser.Parser;
import com.discord.simpleast.core.node.Node;
import com.discord.simpleast.core.parser.Rule;
import com.discord.utilities.textprocessing.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public final class HeaderRule extends Rule<MessageRenderContext, HeaderNode, MessageParseState {
    public HeaderRule() {
        super(Pattern.compile("^\\s*(#+)[ \\t](.*) *(?=\\n|$)"));
    }

    @Override
    public ParseSpec<MessageRenderContext, MessageParseState> parse(Matcher matcher, Parser<MessageRenderContext, ? super LinkNode<MessageRenderContext>, MessageParseState> parser, MessageParseState s) {
        HeaderNode textNode = new HeaderNode(matcher.group(0));
        return new ParseSpec<>(textNode, s);
    }
}