package t0206.creepercontrolsystem.creepercontrolsystem;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import net.md_5.bungee.api.chat.*;
import net.md_5.bungee.chat.*;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public final class InventoryGui extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents( this,this );
    }

    @EventHandler
    public void onPickUp(InventoryClickEvent e){
        Player player = (Player) e.getWhoClicked();
        Inventory open = e.getClickedInventory();
        ItemStack item = e.getCurrentItem();
        if(open == null){
            return;
        }
        if(open.getName().equalsIgnoreCase( "Gui" )){
            e.setCancelled( true);
            if(item == null)return;
            if(item.getItemMeta() !=null){
                if(item.getItemMeta().getDisplayName() !=null){
                    String name = item.getItemMeta().getDisplayName();
                    if(name.contains( "Reload" )){
                        Bukkit.getServer().reload();
                    }else if(name.contains( "Shutdown" )){
                        Bukkit.getServer().shutdown();
                    }else if(name.contains( "HelloWorld" )){
                        player.sendMessage("HelloWorld!")
                    }
                }
            }
        }
    }
}
