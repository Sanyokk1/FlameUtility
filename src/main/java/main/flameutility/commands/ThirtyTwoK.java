package main.flameutility.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class ThirtyTwoK implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player){
            Player p = (Player) sender;

            if(p.hasPermission("flameutility.ttk")){
                Inventory v = Bukkit.createInventory(p, 3, "Легендарное Оружие");
                ItemStack sword = new ItemStack(Material.DIAMOND_SWORD, 1);
                ItemMeta swmeta = sword.getItemMeta();
                sword.addUnsafeEnchantment(Enchantment.KNOCKBACK, 32000);
                sword.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 32000);
                sword.addUnsafeEnchantment(Enchantment.MENDING, 32000);
                swmeta.setUnbreakable(true);
                swmeta.setDisplayName(ChatColor.DARK_RED + "SWORD 32K");
                ArrayList<String> lore = new ArrayList<>();
                lore.add(ChatColor.LIGHT_PURPLE + "Легендарный меч, способный сразить любого...");
                swmeta.setLore(lore);
                sword.setItemMeta(swmeta);
                v.addItem(sword);

                ItemStack stick = new ItemStack(Material.STICK, 1);
                ItemMeta smeta = stick.getItemMeta();
                ArrayList<String> slore = new ArrayList<>();
                slore.add(ChatColor.AQUA + "Ходят легенды, что бог ковырялся этой палкой у себя в заднице");
                smeta.setDisplayName(ChatColor.GOLD + "STICK OF GOD");
                smeta.setLore(slore);
                smeta.setUnbreakable(true);
                stick.addUnsafeEnchantment(Enchantment.KNOCKBACK, 32200);
                v.addItem(stick);

                ItemStack bow = new ItemStack(Material.BOW, 1);
                ItemMeta bmeta = bow.getItemMeta();
                ArrayList<String> blore = new ArrayList<>();
                blore.add(ChatColor.BLUE + "По статистике, все, в кого попадала стрела, пущенная из этого лука - умирали");
                bmeta.setDisplayName(ChatColor.DARK_RED + "BOW OF BLOOD");
                bmeta.setUnbreakable(true);
                bmeta.setLore(blore);
                bow.addUnsafeEnchantment(Enchantment.ARROW_DAMAGE, 32000);
                bow.addUnsafeEnchantment(Enchantment.ARROW_INFINITE, 1);
                bow.addUnsafeEnchantment(Enchantment.ARROW_FIRE, 1);
                bow.addUnsafeEnchantment(Enchantment.ARROW_KNOCKBACK, 32000);
                bow.setItemMeta(bmeta);
                v.addItem(bow);

                p.openInventory(v);
            }
            else{
                p.sendMessage("Обычным смертным не доступна такая мощь!");
            }

        }
        else {
            sender.sendMessage("Команда только для игроков.");
        }

        return true;
    }
}
