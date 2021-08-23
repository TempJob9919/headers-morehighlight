package com.aliucord.plugins.guildprofiles.pages;

import android.content.Context;
import android.util.Base64;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.aliucord.*;
import com.aliucord.fragments.SettingsPage;
import com.aliucord.plugins.EmojiUtility;
import com.aliucord.utils.RxUtils;
import com.discord.api.permission.Permission;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreStream;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.rest.RestAPI;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MutualFriendsPage extends SettingsPage {

    private final Map<Long, GuildMember> members;
    private final String name;

    public MutualFriendsPage(Map<Long, GuildMember> members, String name) {
        this.members = members;
        this.name = name;
    }

    @Override
    public void onViewBound(View view) {
        super.onViewBound(view);
        var storeUserRelationships = StoreStream.getUserRelationships();
        var users = (members.entrySet().stream().filter(aLong -> storeUserRelationships.getRelationships().get(aLong.getKey()) == 1).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        setActionBarTitle(users.size() + " Mutual Friends");
        setActionBarSubtitle(name);

        var ctx = view.getContext();

        setPadding(0);

        var recycler = new RecyclerView(ctx);
        recycler.setLayoutManager(new LinearLayoutManager(ctx, RecyclerView.VERTICAL, false));
        var adapter = new Adapter(this, users.values());
        recycler.setAdapter(adapter);

        addView(recycler);
    }
}