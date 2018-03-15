package org.trident.world.content.skills.impl.thieving;

import org.trident.model.Animation;
import org.trident.model.Skill;
import org.trident.util.Misc;
import org.trident.world.entity.player.Player;

/**
 * Handles the Ardougne chest which can be looted every 24 hours with 99 Thieving.
 * @author Gabbe
 */
public class MastersChest {

	/*
	 * The random chest rewards a player can receive
	 */
	private static final int[][] rewards = {
		{15332, 1}, {14472, 1}, {14474, 1}, {14476, 1}, {14478, 1}, {2364, 10}, {405, 1}, {4831, 10}, {4833, 10}, {4835, 10}, {1514, 10}, {2631, 1}, {1437, 100}, {7937, 50}, {6856, 1}, {1187, 1}, {1079, 1}, {1127, 1}, {1163, 1}, {1333, 1}, {4587, 1}, {1149, 1}, {1213, 1}, {6599, 1}, {225, 1}, {2992, 1}, {634, 1}, {554, 100}, {555, 100}, {556, 100}, {557, 100}, {558, 100}, {559, 100}, {560, 100}, {561, 100}, {562, 100}, {563, 100}, {564, 100}, {565, 100}, {566, 100}, {1438, 1}, {1440, 1}, {1442, 1}, {1444, 1}, {1446, 1}, {1448, 1}, {1450, 1}, {1452, 1}, {1454, 1}, {1456, 1}, {1458, 1}, {1460, 1}, {1462, 1}, {439, 100}, {441, 100}, {443, 100}, {445, 100}, {448, 80}, {449, 50}, {451, 25}, {1077, 1}, {1089, 1}, {1125, 1}, {1151, 1}, {1165, 1}, {1283, 1}, {1313, 1}, {803, 5}, {809, 10}, {828, 5}, {866, 10}, {888, 25}, {1071, 1}, {1085, 1}, {1109, 1}, {1121, 1}, {1143, 1}, {1159, 1}, {1181, 1}, {1197, 1}, {1209, 1}, {1329, 1}, {867, 10}, {829, 10}, {890, 10}, {1073, 1}, {1111, 1}, {1123, 1}, {1145, 1}, {1161, 1}, {830, 10}, {868, 10}, {892, 20}, {1079, 1}, {1093, 1}, {1113, 1}, {1127, 1}, {1147, 1}, {1163, 1}, {1185, 1}, {1201, 1}, {1213, 1}, {1275, 1}, {1303, 1}, {1333, 1}, {1347, 1}, {1359, 1}, {1514, 10}, {2631, 1},{2388, 1}, {1437, 100}, {7937, 50}, {6856, 1}, {1187, 1}, {1079, 1}, {1127, 1}, {1163, 1}, {1333, 1}, {4587, 1}, {1149, 1}, {1213, 1}, {6599, 1}, {225, 1}, {2992, 1}, {634, 1}, {554, 100}, {555, 100}, {556, 100}, {557, 100}, {558, 100}, {559, 100}, {560, 100}, {561, 100}, {562, 100}, {563, 100}, {564, 100}, {565, 100}, {566, 100}, {1438, 1}, {1440, 1}, {1442, 1}, {1444, 1}, {1446, 1}, {1448, 1}, {1450, 1}, {1452, 1}, {1454, 1}, {1456, 1}, {1458, 1}, {1460, 1}, {1462, 1}, {439, 100}, {441, 100}, {443, 100}, {445, 100}, {448, 80}, {449, 50}, {451, 25}, {1077, 1}, {1089, 1}, {1125, 1}, {1151, 1}, {1165, 1}, {1283, 1}, {1313, 1}, {803, 5}, {809, 10}, {828, 5}, {866, 10}, {888, 25}, {1071, 1}, {1085, 1}, {1109, 1}, {1121, 1}, {1143, 1}, {1159, 1}, {1181, 1}, {1197, 1}, {1209, 1}, {1329, 1}, {867, 10}, {829, 10}, {890, 10}, {1073, 1}, {1111, 1}, {1123, 1}, {1145, 1}, {1161, 1}, {830, 10}, {868, 10}, {892, 20}, {1079, 1}, {1093, 1}, {1113, 1}, {1127, 1}, {1147, 1}, {1163, 1}, {1185, 1}, {1201, 1}, {1213, 1}, {1275, 1}, {1303, 1}, {1333, 1}, {1347, 1}, {1359, 1}, {1514, 10}, {2631, 1},{2388, 1}, {1437, 100}, {7937, 50}, {6856, 1}, {1187, 1}, {1079, 1}, {1127, 1}, {1163, 1}, {1333, 1}, {4587, 1}, {1149, 1}, {1213, 1}, {6599, 1}, {225, 1}, {2992, 1}, {634, 1}, {554, 100}, {555, 100}, {556, 100}, {557, 100}, {558, 100}, {559, 100}, {560, 100}, {561, 100}, {562, 100}, {563, 100}, {564, 100}, {565, 100}, {566, 100}, {1438, 1}, {1440, 1}, {1442, 1}, {1444, 1}, {1446, 1}, {1448, 1}, {1450, 1}, {1452, 1}, {1454, 1}, {1456, 1}, {1458, 1}, {1460, 1}, {1462, 1}, {439, 100}, {441, 100}, {443, 100}, {445, 100}, {448, 80}, {449, 50}, {451, 25}, {1077, 1}, {1089, 1}, {1125, 1}, {1151, 1}, {1165, 1}, {1283, 1}, {1313, 1}, {803, 5}, {809, 10}, {828, 5}, {866, 10}, {888, 25}, {1071, 1}, {1085, 1}, {1109, 1}, {1121, 1}, {1143, 1}, {1159, 1}, {1181, 1}, {1197, 1}, {1209, 1}, {1329, 1}, {867, 10}, {829, 10}, {890, 10}, {1073, 1}, {1111, 1}, {1123, 1}, {1145, 1}, {1161, 1}, {830, 10}, {868, 10}, {892, 20}, {1079, 1}, {1093, 1}, {1113, 1}, {1127, 1}, {1147, 1}, {1163, 1}, {1185, 1}, {1201, 1}, {1213, 1}, {1275, 1}, {1303, 1}, {1333, 1}, {1347, 1}, {1359, 1}, {1514, 10}, {2631, 1},{2388, 1}, {1437, 100}, {7937, 50}, {6856, 1}, {1187, 1}, {1079, 1}, {1127, 1}, {1163, 1}, {1333, 1}, {4587, 1}, {1149, 1}, {1213, 1}, {6599, 1}, {225, 1}, {2992, 1}, {634, 1}, {554, 100}, {555, 100}, {556, 100}, {557, 100}, {558, 100}, {559, 100}, {560, 100}, {561, 100}, {562, 100}, {563, 100}, {564, 100}, {565, 100}, {566, 100}, {1438, 1}, {1440, 1}, {1442, 1}, {1444, 1}, {1446, 1}, {1448, 1}, {1450, 1}, {1452, 1}, {1454, 1}, {1456, 1}, {1458, 1}, {1460, 1}, {1462, 1}, {439, 100}, {441, 100}, {443, 100}, {445, 100}, {448, 80}, {449, 50}, {451, 25}, {1077, 1}, {1089, 1}, {1125, 1}, {1151, 1}, {1165, 1}, {1283, 1}, {1313, 1}, {803, 5}, {809, 10}, {828, 5}, {866, 10}, {888, 25}, {1071, 1}, {1085, 1}, {1109, 1}, {1121, 1}, {1143, 1}, {1159, 1}, {1181, 1}, {1197, 1}, {1209, 1}, {1329, 1}, {867, 10}, {829, 10}, {890, 10}, {1073, 1}, {1111, 1}, {1123, 1}, {1145, 1}, {1161, 1}, {830, 10}, {868, 10}, {892, 20}, {1079, 1}, {1093, 1}, {1113, 1}, {1127, 1}, {1147, 1}, {1163, 1}, {1185, 1}, {1201, 1}, {1213, 1}, {1275, 1}, {1303, 1}, {1333, 1}, {1347, 1}, {1359, 1},
	};

	/**
	 * Handles the chest looting
	 * @param player	The player looting the Master's chest.
	 */
	public static void handleChest(Player player) {
		if(player.getSkillManager().getMaxLevel(Skill.THIEVING) < 99) {
			player.getPacketSender().sendMessage("You need to have level 99 Thieving to open this.");
			return;
		}
		if(player.getInventory().getFreeSlots() < 10) {
			player.getPacketSender().sendMessage("You need to have 10 free inventory slots to search this chest.");
			return;
		}
		if(System.currentTimeMillis() - player.getAttributes().getArdougneChestLootingDelay() >= 86400000) {
			player.performAnimation(new Animation(827));
			int index = Misc.getRandom(rewards.length - 1);
			player.getInventory().add(rewards[index][0], rewards[index][1]);
			player.getInventory().refreshItems();
			player.getPacketSender().sendMessage("You will be able to loot the Master's chest again in 24 hours.");
			player.getAttributes().setArdougneChestLootingDelay(System.currentTimeMillis()).setClickDelay(System.currentTimeMillis());
			player.getPacketSender().sendClientRightClickRemoval();
		} else {
			player.getPacketSender().sendMessage("This chest can only be opened every 24 hours.");
		}
	}
}
