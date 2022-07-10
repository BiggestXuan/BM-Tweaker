package com.biggestxuan.bmtweaker.network;

import com.blamejared.crafttweaker.api.CraftTweakerAPI;
import com.blamejared.crafttweaker.api.CraftTweakerGlobals;
import com.blamejared.crafttweaker.api.annotations.ZenRegister;
import net.minecraft.entity.player.PlayerEntity;
import org.openzen.zencode.java.ZenCodeType;
import wayoftime.bloodmagic.core.data.SoulNetwork;
import wayoftime.bloodmagic.util.helper.NetworkHelper;

import java.util.UUID;

@ZenRegister
@ZenCodeType.Name("mods.bmtweaker.LP")
public class player {
    public static UUID getUUID(PlayerEntity player){
        return player.getUUID();
    }
    public static SoulNetwork getNetworkForPlayer(PlayerEntity player){
        return NetworkHelper.getSoulNetwork(getUUID(player));
    }
    private static void warnLog(){
        CraftTweakerAPI.logWarning("LP cant less than 0!");
        CraftTweakerGlobals.println("LP cant less than 0");
    }
    @ZenCodeType.Method
    public static void setPlayerLP(PlayerEntity player,int num){
        getNetworkForPlayer(player).setCurrentEssence(Math.max(0,num));
    }
    @ZenCodeType.Method
    public static int getPlayerLP(PlayerEntity player){
        return getNetworkForPlayer(player).getCurrentEssence();
    }
    @ZenCodeType.Method
    public static void addPlayerLP(PlayerEntity player,int num){
        int c;
        if(num <0){
            c = 0;
            warnLog();
        }else c = num;
        setPlayerLP(player,getPlayerLP(player)+c);
    }
    @ZenCodeType.Method
    public static void lossPlayerLP(PlayerEntity player,int num){
        int c;
        if(num<0){
            c = 0;
            warnLog();
        }else c = num;
        setPlayerLP(player,Math.max(getPlayerLP(player)-c,0));
    }
}
