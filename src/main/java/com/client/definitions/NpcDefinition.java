package com.client.definitions;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.IntStream;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.util.Arrays;
//
//import org.apache.commons.io.FileUtils;

import com.client.*;
import com.client.model.Npcs;
import com.client.utilities.FieldGenerator;
import com.client.utilities.TempWriter;
import net.runelite.api.HeadIcon;
import net.runelite.api.IterableHashTable;
import net.runelite.rs.api.RSIterableNodeHashTable;
import net.runelite.rs.api.RSNPCComposition;


public final class NpcDefinition implements RSNPCComposition {

	public static NpcDefinition lookup(int i) {
		for (int j = 0; j < 20; j++)
			if (cache[j].npcId == i)
				return cache[j];

		anInt56 = (anInt56 + 1) % 20;
		NpcDefinition entityDef = cache[anInt56] = new NpcDefinition();
		stream.currentPosition = streamIndices[i];
		entityDef.npcId = i;
		entityDef.readValues(stream);
		switch(i){
			case 11958:
				//entityDef.models = new int[] { 7400 };
				return copy(entityDef, 11958, 2205, "Vote boss",new int[] {57989, 57937, 57985, 57968, 57990}, 1000, null, "Attack", null, null, null);
			case 11959:
				//entityDef.models = new int[] { 7400 };
				return copy(entityDef, 11959, 8633, "Legendary boss",new int[] {57142}, 1000, null, "Attack", null, null, null);
			case 11855:
				//entityDef.models = new int[] { 7400 };
				return copy(entityDef, 11855, 6633, "Vote boss jr",new int[] {57989, 27937, 57985, 57968, 27990}, 0, "Talk-to", null, "Pick-Up", null, null);
			case 11960:
				return copy(entityDef, 11960, 9120, "Donation Shop 2", 0, "Trade", null, "Rewards", null, null );

		}
		if (i == Npcs.BOB_BARTER_HERBS) {
			entityDef.actions = new String[] { "Talk-to", "Prices", "Decant", "Clean", null };
		}
		if(i == 7553){
        entityDef.name = "Great Olm (Right claw)";
        entityDef.combatLevel = 549;
        entityDef.size = 5;
        entityDef.aBoolean93 = true;
        entityDef.aBoolean84 = true;
        entityDef.actions = new String[] { null, "Attack", null, null, null };
        }
        if(i == 7554){
            entityDef.name = "Great Olm";
            entityDef.combatLevel = 1043;
            entityDef.size = 5;
            entityDef.aBoolean93 = true;
            entityDef.aBoolean84 = true;
            entityDef.actions = new String[] { null, "Attack", null, null, null };
        }
        if(i == 7555){
            entityDef.name = "Great Olm (Left claw)";
            entityDef.combatLevel = 750;
            entityDef.size = 5;
            entityDef.aBoolean93 = true;
            entityDef.aBoolean84 = true;
            entityDef.actions = new String[] { null, "Attack", null, null, null };
        }
		if (i == Npcs.ZAHUR)
			entityDef.actions[0] = "Trade";
		if (i == Npcs.JOSSIK) {
			entityDef.actions = new String[5];
			entityDef.actions[0] = "Talk-to";
			entityDef.actions[2] = "Trade";
		}
		if (i == 9460 || i == 1150 || i == 2912 || i == 2911 || i == 2910 || i == 6481
				|| i == 3500 || i == 9459 || i == 9457 || i == 9458) {
			// Setting combat to zero to npcs that can't be attacked
			entityDef.combatLevel = 0;
		}
		if (i == Npcs.PERDU) {
			entityDef.actions = new String[] { "Talk-to", null, "Reclaim-lost", null, null};
		}
		if (i == 8184) {
			entityDef.name = "Theatre Of Blood Wizard";
			entityDef.actions = new String[5];
			entityDef.actions[0] = "Teleport";
		}
		if (i == 7599) {
			entityDef.name = "Exilius Guide";
		}
		if (i == 4305) {
			entityDef.name = "Drunken cannoneer";
			entityDef.actions = new String[5];
			entityDef.actions[0] = "Pickpocket";
		}
		if(i == 3362){
			entityDef.standAnimation = 813;
			entityDef.walkAnimation = 1205;
			entityDef.rotate90RightAnimation = 1207;
			entityDef.rotate180Animation = 1206;
		}
		if (i == 3247) {
			entityDef.name = "Wizard";
			entityDef.actions = new String[5];
			entityDef.actions[0] = "Teleport";
		}
		if (i == 6517) {
			entityDef.name = "Daily-reward wizard";
			entityDef.actions = new String[5];
			entityDef.actions[0] = "Talk-to";
			entityDef.actions[2] = "View rewards";
		}
		if (i == 3428 || i == 3429) {
			entityDef.name = "Elf warrior";
		}
		if (i == 5044) { // sanfew (decant)
			entityDef.actions = new String[5];
			entityDef.actions[0] = "Decant-potions";
		}
		if (i == 8026) {
			entityDef.combatLevel = 392;
		}
		if (i == 7913) {
			entityDef.combatLevel = 0;
			entityDef.name = "Ironman shop keeper";
			entityDef.description = "A shop specifically for iron men.";
		}
		if (i == 8906) {
			entityDef.combatLevel = 0;
			entityDef.name = "Santa's little elf";
			entityDef.description = "A helper sent from santa himself.";
			entityDef.actions = new String[] { "Talk-To", null, "Christmas Shop", "Return-Items", null };
		}
		if (i == 954) {
			entityDef.combatLevel = 0;
			entityDef.name = "Crystal Seed Trader";
			entityDef.description = "Use a seed on me to get a Crystal Bow.";

		}
		if (i == 6970) {
			entityDef.combatLevel = 0;
			entityDef.name = "Theif";
			entityDef.actions = new String[] { null, null, "Pickpocket",  null,  null };
		}
		if (i == 8761) {
			entityDef.combatLevel = 0;
			entityDef.actions = new String[] { "Talk-to", null, "Assignment", "Trade", "Rewards" };

		}
		if (i == 9400) {
			entityDef.name = "Ted O'bombr";
		}
		if (i == 8026 || i == 8027 || i == 8028) {
			entityDef.size = 9;
		}
		if (i == 7954) {
			entityDef.combatLevel = 0;
			entityDef.name = "Achievement Master";
			entityDef.actions = new String[] { "Trade", null, "Open Achievements", null, null, };

		}
		if (i == 5870) {
			entityDef.combatLevel = 0;
			entityDef.actions = new String[] { "Talk-to", null, "Assignment", "Trade", "Rewards" };

		}
		if (i == 3400) {
			entityDef.combatLevel = 0;
			entityDef.name = "Giveaway Manager";
			entityDef.actions = new String[] { "Open-manager", null, null, null, null };

		}
		if (i == 1013) {
			entityDef.combatLevel = 0;
			entityDef.name = "Gambler Shop";
			entityDef.description = "A shop specifically for gamblers.";
		}
		if (i == 308) {
			entityDef.combatLevel = 0;
			entityDef.name = "PKP Manager";
		}
		if (i == 13) {
			entityDef.combatLevel = 0;
			entityDef.name = "Referral Tutor";
			entityDef.description = "He manages referrals.";
		}
		if (i == 5293) {
			entityDef.combatLevel = 0;
			entityDef.name = "Elven Keeper";
		}
		if(i==3218 || i ==3217){
			entityDef.combatLevel = 0;
			entityDef.actions = new String[] { "Trade", null, null, null, null };
		}
		if(i==2897){
			entityDef.combatLevel = 0;
			entityDef.name = "Trading Post Manager";
			entityDef.actions = new String[] { "Open", null, "Collect", null, null };
		}
		if(i==1306){
			entityDef.combatLevel = 0;
			entityDef.actions = new String[] { "Make-over", null, null, null, null };
		}
		if(i==1011){
			entityDef.combatLevel = 0;
			entityDef.name = "Item Gambler";
			entityDef.actions = new String[] { "Info", null, "Gamble", null, null };
		}
		if(i==3248){
			entityDef.combatLevel = 0;
			entityDef.name = Configuration.CLIENT_TITLE + " Wizard";
			entityDef.actions = new String[] { "Teleport", null, "Previous Location", null, null };
		}
		if(i==1520){
			entityDef.combatLevel = 0;
			entityDef.actions = new String[] { "Small Net", null, "Harpoon", null, null };
		}
		if(i==8920){

			entityDef.actions = new String[] { null, "Attack", null, null, null };
		}
		if(i==8921){
			entityDef.name = "Crystal Whirlwind";
		}
		if(i==9120){
			entityDef.combatLevel = 0;
			entityDef.name = "Donator Shop";
			entityDef.actions = new String[] { "Trade", null, "Rewards", null, null };
		}
		if(i == 2662){
			entityDef.combatLevel = 0;
			entityDef.name = "Tournament Manager";
			entityDef.actions = new String[] { "Open-Shop", null, null, null, null };
		}
		if(i==603){
			entityDef.combatLevel = 0;
			entityDef.name = "Captain Kraken";
			entityDef.actions = new String[] { "Talk-to", null, null, null, null };
		}
		if(i==7041){
			entityDef.combatLevel = 0;
			entityDef.name = "Ticket Exchange";
			entityDef.actions = new String[] { "Exchange", null, null, null, null };
		}
		if(i==3894){
			entityDef.combatLevel = 0;
			entityDef.name = "Sigmund The Merchant";
			entityDef.actions = new String[] { "Trade", null, null, null, null };
		}

		if (i==7413) {
			entityDef.name = "Max Dummy";
			entityDef.actions[0] = null;
		}
		if(i==9011){
			entityDef.combatLevel = 0;
			entityDef.name = "Vote Shop";
			entityDef.actions = new String[] { "Trade", null, null, null, null };
		}
		if(i==1933){
			entityDef.combatLevel = 0;
			entityDef.name = "Mills";
			entityDef.actions = new String[] { "Trade", null, null, null, null };
		}
		if(i==8819){
			entityDef.combatLevel = 0;
			entityDef.name = "Boss point shop";
			entityDef.actions = new String[] { null, null, "Trade", null, null };
		}
		if(i==8688){
			entityDef.combatLevel = 0;
			entityDef.name = "Fat Tony";
			entityDef.actions = new String[] { "Trade", null, null, null, null };
		}
		if(i==7769){
			entityDef.combatLevel = 0;
			entityDef.name = "Shop Keeper";
			entityDef.actions = new String[] { "Trade", null, null, null, null };
		}
		if(i==6987){
			entityDef.combatLevel = 0;
			entityDef.name = "Man";
			entityDef.actions = new String[] { "Talk", null, "Pickpocket", null, null };
		}
		if(i==5730){
			entityDef.combatLevel = 0;
			entityDef.name = "Master Farmer";
			entityDef.actions = new String[] { "Pickpocket", null, "Trade", null, null };
		}
		if(i==1501){
			entityDef.combatLevel = 0;
			entityDef.name = "Hunter Store";
			entityDef.actions = new String[] { null, null, null, null, "Trade" };
		}
		if(i==2913){
			entityDef.combatLevel = 0;
			entityDef.name = "Fishing Store";
			entityDef.actions = new String[] { "Trade", null, null, null, null };
		}
		if(i==5809){
			entityDef.combatLevel = 0;
			entityDef.name = "Crafting and Tanner";
			entityDef.actions = new String[] { "Tan", null, "Trade", null, null };
		}
		if(i==555){
			entityDef.combatLevel = 0;
			entityDef.name = "Sell Me Store";
			entityDef.actions = new String[] { "Trade", null, null, null, null };
		}
		if(i==9168){
			entityDef.combatLevel = 0;
			entityDef.name = "Flex";
			entityDef.actions = new String[] { "Trade", null, null, null, null };
		}
		if(i==8208){
			entityDef.combatLevel = 0;
			entityDef.name = "Pet Collector";
			entityDef.actions = new String[] { "Talk-to", null, null, null, null };
		}
		if(i==8202){
			entityDef.actions = new String[] { "Talk-to", "Pick-Up", null, null, null };
		}
		if(i==4921){
			entityDef.combatLevel = 0;
			entityDef.name = "Supplies";
			entityDef.actions = new String[] { "Trade", null, null, null, null };
		}
		if (i == 5314) {
			entityDef.combatLevel = 0;
			entityDef.name = "Mystical Wizard";
			entityDef.actions = new String[] { "Teleport", "Previous Location", null, null, null };
			entityDef.description = "This wizard has the power to teleport you to many locations.";
		}
		if (i == 8781) {
			entityDef.name = "@red@Queen Latsyrc";
			entityDef.combatLevel = 982;
			entityDef.onMinimap = true;
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { null, "Attack", null, null, null };
		}
		if(i==1577){
			entityDef.combatLevel = 0;
			entityDef.name = "Melee Shop";
			entityDef.combatLevel = 0;
			entityDef.actions = new String[] { "Trade", null, null, null, null };
		}
		if(i==1576){
			entityDef.combatLevel = 0;
			entityDef.name = "Range Shop";
			entityDef.combatLevel = 0;
			entityDef.actions = new String[] { "Trade", null, null, null, null };
		}
		if(i==1578){
			entityDef.combatLevel = 0;
			entityDef.name = "Mage Shop";
			entityDef.combatLevel = 0;
			entityDef.actions = new String[] { "Trade", null, null, null, null };
		}
		if (i == 8026) {
			entityDef.name = "Vorkath";
			// entityDef.combatLevel = 732;
			entityDef.models = new int[] { 35023 };
			entityDef.standAnimation = 7946;
			entityDef.onMinimap = true;
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { "Poke", null, null, null, null };
			entityDef.anInt86 = 100;
			entityDef.anInt91 = 100;
		}
		if (i == 7852 || i == 7853 || i == 7884) {//Dawn
			entityDef.standAnimation = 7775;
			entityDef.walkAnimation = 7775;
		}
		if (i == 5518) {
			entityDef.standAnimation = 185;
		}
		if (i == 8019) {
			entityDef.standAnimation = 185;
			entityDef.actions = new String[5];
			entityDef.actions[0] = "Talk-to";
			entityDef.actions[2] = "Trade";
		}
		if (i == 308) {
			entityDef.actions = new String[5];
			entityDef.actions[0] = "Talk-to";
			entityDef.actions[2] = "Trade";
			entityDef.actions[3] = "Disable Interface";
			entityDef.actions[4] = "Skull";
		}
		if (i == 6088) {
			entityDef.standAnimation = 185;
			entityDef.actions = new String[5];
			entityDef.actions[0] = "Talk-to";
			entityDef.actions[2] = "Travel";
		}
		if (i == 1434 || i == 876 || i == 1612) {//gnome fix
			entityDef.standAnimation = 185;
		}
		if (i == 7674 || i == 8009 || i == 388 || i == 8010) {

			entityDef.combatLevel = 0;
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { "Talk-to", null, "Pick-Up", "Metamorphosis", null };
		}
		if (i == 8492 || i == 8493 || i == 8494 || i == 8495) {
			entityDef.combatLevel = 0;
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { "Talk-to", null, "Pick-Up", "Metamorphosis", null };
		}
		if (i == 8737 || i == 8738 || i == 8009 || i == 7674) {
			entityDef.combatLevel = 0;
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { "Talk-to", null, "Pick-Up", "Metamorphosis", null };
		}
		if (i == 326 || i == 327) {
			entityDef.combatLevel = 0;
			entityDef.anInt86 = 85;
			entityDef.anInt91 = 85;
			entityDef.name = "Vote Pet";
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { "Talk-to", null, "Pick-Up", "Metamorphosis", null };
		}
		if (i >= 7354 && i <=7367) {
			entityDef.combatLevel = 0;
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { "Talk-to", null, "Pick-Up", "Metamorphosis", null };
		}
		if (i == 5559 || i == 5560) {
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { "Talk-to", null, "Pick-Up", "Metamorphosis", null };
		}
		if (i == 2149 || i == 2150 || i == 2151 || i == 2148) {
			entityDef.name = "Trading Clerk";
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { "Bank", null, "Trading Post", null, null };
		}
		if (i == 6473) { //terror dog
			entityDef.combatLevel = 0;
			entityDef.anInt86 = 50; //WIDTH
			entityDef.anInt91 = 50; // HEIGH
		}
		if (i == 3510) { //outlast shop
			entityDef.name = "Trader";
			entityDef.combatLevel = 0;
			entityDef.onMinimap = true;
			entityDef.anInt86 = 150; //WIDTH
			entityDef.anInt91 = 150; // HEIGH
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { "Open-Shop", null, null, null, null };
		}
		if (i == 488) { //rain cloud
			entityDef.combatLevel = 0;
			entityDef.size = 1;
			entityDef.onMinimap = true;
			entityDef.anInt86 = 150; //WIDTH
			entityDef.anInt91 = 150; // HEIGH
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { "Talk-to", null, "Pick-Up", null, null };
		}
		if (i == 7668) { //voice of yama
			entityDef.name = "Kratos";
			entityDef.size = 2;
			entityDef.combatLevel = 0;
			entityDef.anInt86 = 90; //WIDTH
			entityDef.anInt91 = 90; // HEIGH
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { "Talk-to", null, "Pick-Up", null, null };

		}
		if (i == 1377) {
			entityDef.size = 3;
			entityDef.anInt86 = 300; //WIDTH
			entityDef.anInt91 = 300; // HEIGH
			entityDef.actions[0] = null;


		}
		if (i == 2105) {
			entityDef.size = 4;
			entityDef.anInt86 = 600; //WIDTH
			entityDef.anInt91 = 600; // HEIGH
		}
		if (i == 2107) {
			entityDef.size = 4;
			entityDef.anInt86 = 600; //WIDTH
			entityDef.anInt91 = 600; // HEIGH
		}
		if (i == 2850) {
			entityDef.name = "GIM Tracker";
			entityDef.actions = new String[] { "Open", null, null, null, null };

		}
		if (i == 6119) { //weird monster
			entityDef.size = 1;
			entityDef.combatLevel = 0;
			entityDef.anInt86 = 30; //WIDTH
			entityDef.anInt91 = 30; // HEIGH
		}
		if (i == 763) { //roc

			entityDef.size = 1;
			entityDef.combatLevel = 0;
			entityDef.anInt86 = 30; //WIDTH
			entityDef.anInt91 = 30; // HEIGH
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { "Talk-to", null, "Pick-Up", "Metamorphosis", null };


		}
		if (i == 762) { //foe small bird
			entityDef.size = 1;
			entityDef.combatLevel = 0;
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { "Talk-to", null, "Pick-Up", "Metamorphosis", null };
		}
		if (i == 4987 || i == 6292 || i == 6354 ) { //chronzon
			entityDef.size = 1;
			entityDef.combatLevel = 0;
			entityDef.anInt86 = 45; //WIDTH
			entityDef.anInt91 = 45; // HEIGH
		}
		if (i == 8709) {
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { "Talk-to", null, "Pick-Up", null, null };
			entityDef.name = "Corrupt Beast";
			entityDef.combatLevel = 0;
			entityDef.anInt86 = 60; //WIDTH
			entityDef.anInt91 = 60; // HEIGH
			entityDef.size = 1;
		}
		if (i == 7025) { //guard dog
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { "Talk-to", null, "Pick-Up", null, null };
			entityDef.anInt86 = 85; //WIDTH
			entityDef.anInt91 = 85; // HEIGH
		}

		if (i == 6716) {//prayer
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { "Talk-to", null, "Pick-Up", null, null };
			entityDef.anInt86 = 65; //WIDTH
			entityDef.anInt91 = 65; // HEIGH
			entityDef.combatLevel = 0;


		}
//			if (i == 6723) {//healer
//				entityDef.actions = new String[5];
//				entityDef.actions = new String[] { "Talk-to", null, "Pick-Up", null, null };
//				entityDef.anInt86 = 65; //WIDTH
//				entityDef.anInt91 = 65; // HEIGH
//				entityDef.combatLevel = 0;
//
//			}
		if (i == 1088) {
			entityDef.name = "Seren";
			entityDef.models = new int[] { 38605 };
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { "Talk-to", null, "Pick-Up", null, null };
			entityDef.anInt86 = 65; //WIDTH
			entityDef.anInt91 = 65; // HEIGH
			entityDef.originalColors = null;
			entityDef.newColors = null;
			entityDef.combatLevel = 0;
			entityDef.standAnimation = 8372;
			entityDef.walkAnimation = 8372;
			entityDef.models = new int[] { 38605 };

		}
		if (i == 1089) {
			entityDef.name = "Lil mimic";
			entityDef.models = new int[] { 37142 };
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { "Talk-to", null, "Pick-Up", null, null };
			entityDef.anInt86 = 25; //WIDTH
			entityDef.anInt91 = 25; // HEIGH
			entityDef.originalColors = null;
			entityDef.newColors = null;
			entityDef.combatLevel = 0;
			entityDef.standAnimation = 8307;
			entityDef.walkAnimation = 8306;
			entityDef.models = new int[] { 37142 };

		}
		if (i == 2120) {
			entityDef.name = "Shadow Ranger";
			entityDef.models = new int[] { 29267 };
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { "Talk-to", null, "Pick-Up", null, null };
			entityDef.anInt86 = 85; //WIDTH
			entityDef.anInt91 = 85; // HEIGH
			entityDef.originalColors = null;
			entityDef.newColors = null;
			entityDef.combatLevel = 0;
			entityDef.standAnimation = 8526;
			entityDef.walkAnimation = 8527;
			entityDef.models = new int[] { 29267 };

		}
		if (i == 2121) {
			entityDef.name = "Shadow Wizard";
			entityDef.models = new int[] { 29268 };
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { "Talk-to", null, "Pick-Up", null, null };
			entityDef.anInt86 = 85; //WIDTH
			entityDef.anInt91 = 85; // HEIGH
			entityDef.originalColors = null;
			entityDef.newColors = null;
			entityDef.combatLevel = 0;
			entityDef.standAnimation = 8526;
			entityDef.walkAnimation = 8527;
			entityDef.models = new int[] { 29268 };
		}
		if (i == 2122) {
			entityDef.name = "Shadow Warrior";
			entityDef.models = new int[] { 29266 };
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { "Talk-to", null, "Pick-Up", null, null };
			entityDef.anInt86 = 85; //WIDTH
			entityDef.anInt91 = 85; // HEIGH
			entityDef.originalColors = null;
			entityDef.newColors = null;
			entityDef.combatLevel = 0;
			entityDef.standAnimation = 8526;
			entityDef.walkAnimation = 8527;
			entityDef.models = new int[] { 29266 };
		}

		if (i == 7216 || i == 6473) {//green monkey and green dog
			entityDef.actions = new String[5];
			entityDef.combatLevel = 0;
			entityDef.actions = new String[] { "Talk-to", null, "Pick-Up", null, null };
		}
		if (i == 6716 || i == 8709) {
			entityDef.actions = new String[5];
			entityDef.combatLevel = 0;
			entityDef.actions = new String[] { "Talk-to", null, "Pick-Up", null, null };
		}
		if (i == 3291) {//postie pete
			entityDef.actions = new String[5];
			entityDef.combatLevel = 0;
			entityDef.actions = new String[] { "Talk-to", null, "Pick-Up", null, null };
		}
		if (i == 5738) {//imp
			entityDef.actions = new String[5];
			entityDef.combatLevel = 0;
			entityDef.actions = new String[] { "Talk-to", null, "Pick-Up", null, null };

		}
		if (i == 5240) {//toucan
			entityDef.actions = new String[5];
			entityDef.combatLevel = 0;
			entityDef.actions = new String[] { "Talk-to", null, "Pick-Up", null, null };

		}
		if (i == 834) {
			entityDef.name = "King penguin";
			entityDef.actions = new String[5];
			entityDef.combatLevel = 0;
			entityDef.actions = new String[] { "Talk-to", null, "Pick-Up", null, null };

		}
		if (i == 1873) {//klik
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { "Talk-to", null, "Pick-Up", null, null };
			entityDef.standAnimation = 3345;
			entityDef.walkAnimation = 3346;

		}
		//dark pets
		//dark pets
		if (i == 2300) {
			entityDef.models = new int[1];
			entityDef.name = "Dark postie pete";
			entityDef.models = new int[] { 56601 };
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { "Talk-to", null, "Pick-Up", null, null };
			entityDef.originalColors = null;
			entityDef.newColors = null;
			entityDef.combatLevel = 0;
			entityDef.standAnimation = 3948;
			entityDef.walkAnimation = 3947;
		}
		if (i == 2301) {
			entityDef.name = "Dark imp";
			entityDef.models = new int[] { 56602 };
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { "Talk-to", null, "Pick-Up", null, null };
			entityDef.originalColors = null;
			entityDef.newColors = null;
			entityDef.combatLevel = 0;
			entityDef.standAnimation = 171;
			entityDef.walkAnimation = 168;
		}
		if (i == 2302) {
			entityDef.name = "Dark toucan";
			entityDef.models = new int[] { 56603, 56604 };
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { "Talk-to", null, "Pick-Up", null, null };
			entityDef.originalColors = null;
			entityDef.newColors = null;
			entityDef.combatLevel = 0;
			entityDef.standAnimation = 6772;
			entityDef.walkAnimation = 6774;
		}
		if (i == 2303) {
			entityDef.name = "Dark king penguin";
			entityDef.models = new int[] { 56605 };
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { "Talk-to", null, "Pick-Up", null, null };
			entityDef.originalColors = null;
			entityDef.newColors = null;
			entityDef.combatLevel = 0;
			entityDef.standAnimation = 5668;
			entityDef.walkAnimation = 5666;
		}
		if (i == 2313) {
			entityDef.name = "Dark kratos";
			entityDef.models = new int[] { 56632, 56633, 56634 };
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { "Talk-to", null, "Pick-Up", null, null };
			entityDef.originalColors = null;
			entityDef.newColors = null;
			entityDef.standAnimation = 7017;
			entityDef.walkAnimation = 7016;
			entityDef.size = 2;
			entityDef.combatLevel = 0;
			entityDef.anInt86 = 90; //WIDTH
			entityDef.anInt91 = 90; // HEIGH
		}

		if (i == 2304) {
			entityDef.name = "Dark k'klik";
			entityDef.models = new int[] { 56606, 56607, 56608 };
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { "Talk-to", null, "Pick-Up", null, null };
			entityDef.originalColors = null;
			entityDef.newColors = null;
			entityDef.combatLevel = 0;
			entityDef.standAnimation = 3346;
			entityDef.walkAnimation = -1;
		}
		if (i == 2305) {
			entityDef.name = "Dark shadow warrior";
			entityDef.models = new int[] { 56609 };
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { "Talk-to", null, "Pick-Up", null, null };
			entityDef.originalColors = null;
			entityDef.newColors = null;
			entityDef.combatLevel = 0;
			entityDef.standAnimation = 8526;
			entityDef.walkAnimation = 8527;
			entityDef.anInt86 = 85; //WIDTH
			entityDef.anInt91 = 85; // HEIGH
		}
		if (i == 2306) {
			entityDef.name = "Dark shadow archer";
			entityDef.models = new int[] { 56610 };
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { "Talk-to", null, "Pick-Up", null, null };
			entityDef.originalColors = null;
			entityDef.newColors = null;
			entityDef.combatLevel = 0;
			entityDef.standAnimation = 8526;
			entityDef.walkAnimation = 8527;
			entityDef.anInt86 = 85; //WIDTH
			entityDef.anInt91 = 85; // HEIGH
		}
		if (i == 2307) {
			entityDef.name = "Dark shadow wizard";
			entityDef.models = new int[] { 56611 };
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { "Talk-to", null, "Pick-Up", null, null };
			entityDef.originalColors = null;
			entityDef.newColors = null;
			entityDef.combatLevel = 0;
			entityDef.standAnimation = 8526;
			entityDef.walkAnimation = 8527;
			entityDef.anInt86 = 85; //WIDTH
			entityDef.anInt91 = 85; // HEIGH
		}
		if (i == 6723) {
			entityDef.name = "Healer death spawn";
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { "Talk-to", null, "Pick-Up", null, null };
			entityDef.anInt86 = 65; //WIDTH
			entityDef.anInt91 = 65; // HEIGH
			entityDef.combatLevel = 0;
		}
		if (i == 2308) {
			entityDef.name = "Dark healer death spawn";
			entityDef.models = new int[] { 56612, 56613, 56614, 56615, 56616, 56616, 56617,};
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { "Talk-to", null, "Pick-Up", null, null };
			entityDef.originalColors = null;
			entityDef.newColors = null;
			entityDef.anInt86 = 65; //WIDTH
			entityDef.anInt91 = 65; // HEIGH
			entityDef.combatLevel = 0;
			entityDef.standAnimation = 1539;
			entityDef.walkAnimation = 1539;
		}
		if (i == 2309) {
			entityDef.name = "Dark holy death spawn";
			entityDef.models = new int[] { 56624, 56623, 56622, 56621, 56620, 56619, 56618 };
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { "Talk-to", null, "Pick-Up", null, null };
			entityDef.originalColors = null;
			entityDef.newColors = null;
			entityDef.anInt86 = 65; //WIDTH
			entityDef.anInt91 = 65; // HEIGH
			entityDef.combatLevel = 0;
			entityDef.standAnimation = 1539;
			entityDef.walkAnimation = 1539;
		}
		if (i == 2310) {
			entityDef.name = "Dark seren";
			entityDef.models = new int[] { 56625 };
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { "Talk-to", null, "Pick-Up", null, null };
			entityDef.originalColors = null;
			entityDef.newColors = null;
			entityDef.combatLevel = 0;
			entityDef.standAnimation = 8372;
			entityDef.walkAnimation = 8372;
			entityDef.anInt86 = 65; //WIDTH
			entityDef.anInt91 = 65; // HEIGH
		}
		if (i == 2311) {
			entityDef.name = "Dark corrupt beast";
			entityDef.models = new int[] { 56626 };
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { "Talk-to", null, "Pick-Up", null, null };
			entityDef.originalColors = null;
			entityDef.newColors = null;
			entityDef.combatLevel = 0;
			entityDef.anInt86 = 60; //WIDTH
			entityDef.anInt91 = 60; // HEIGH
			entityDef.size = 1;
			entityDef.standAnimation = 5616;
			entityDef.walkAnimation = 5615;
		}
		if (i == 2312) {
			entityDef.name = "Dark roc";
			entityDef.models = new int[] { 56627, 56628 };
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { "Talk-to", null, "Pick-Up", null, null };
			entityDef.originalColors = null;
			entityDef.newColors = null;
			entityDef.standAnimation = 5021;
			entityDef.walkAnimation = 5022;
			entityDef.size = 1;
			entityDef.combatLevel = 0;
			entityDef.anInt86 = 30; //WIDTH
			entityDef.anInt91 = 30; // HEIGH
		}
		if(i == 11855){
			entityDef.name = "Snow Imp";
			entityDef.models = new int[] { 51337 };
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { "Talk-to", null, "Pick-Up", null, null };
			entityDef.originalColors = null;
			entityDef.newColors = null;
			entityDef.standAnimation = 171;
			entityDef.walkAnimation = 168;
			entityDef.size = 1;
			entityDef.combatLevel = 0;
			entityDef.anInt86 = 150; //WIDTH
			entityDef.anInt91 = 150; // HEIGH
		}
		if (i == 8027) {
			entityDef.name = "Vorkath";
			entityDef.combatLevel = 732;
			entityDef.models = new int[] { 35023 };
			entityDef.standAnimation = 7950;
			entityDef.onMinimap = true;
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { null, null, null, null, null };
			entityDef.anInt86 = 100;
			entityDef.anInt91 = 100;
		}
		if (i == 8028) {
			entityDef.name = "Vorkath";
			entityDef.combatLevel = 732;
			entityDef.models = new int[] { 35023 };
			entityDef.standAnimation = 7948;
			entityDef.onMinimap = true;
			entityDef.actions = new String[5];
			entityDef.actions = new String[] { null, "Attack", null, null, null };
			entityDef.anInt86 = 100;
			entityDef.anInt91 = 100;
		}
		if(i==7144){
			entityDef.anInt75 = 0;
		}
		if(i==963){
			entityDef.anInt75 = 6;
		}
		if(i==7145){
			entityDef.anInt75 = 1;
		}
		if(i==7146){
			entityDef.anInt75 = 2;
		}
		if (entityDef.name != null && entityDef.name.toLowerCase().contains("chinchompa") && !entityDef.name.toLowerCase().contains("baby")) {
			entityDef.actions = new String[5];
		}
		return entityDef;
	}
	public static int totalAmount;

	public static void dump() {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter("./npc_defs.txt"))) {
			for (int i = 0; i < 70_000; i++) {
				try {
					NpcDefinition def = NpcDefinition.lookup(i);
					if (def != null) {
						writer.write("Npc=" + i);
						writer.newLine();
						writer.write("Stand animation=" + def.standAnimation);
						writer.newLine();
						writer.write("Walk animation=" + def.walkAnimation);
						writer.newLine();
						writer.newLine();
					}
				} catch (Exception e) {
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void unpackConfig(FileArchive streamLoader) {
		stream = new Buffer(streamLoader.readFile("npc.dat"));
		Buffer stream = new Buffer(streamLoader.readFile("npc.idx"));
		totalAmount = stream.readUShort();
		streamIndices = new int[totalAmount];
		int i = 2;
		for (int j = 0; j < totalAmount; j++) {
			streamIndices[j] = i;
			i += stream.readUShort();
		}

		cache = new NpcDefinition[20];
		for (int k = 0; k < 20; k++)
			cache[k] = new NpcDefinition();
		for (int index = 0; index < totalAmount; index++) {
			NpcDefinition ed = lookup(index);
			if (ed == null)
				continue;
			if (ed.name == null)
				continue;
		}
		if (Configuration.dumpDataLists) {
			NpcDefinitionDumper.dump();

			TempWriter writer2 = new TempWriter("npc_fields");
			FieldGenerator generator = new FieldGenerator(writer2::writeLine);
			IntStream.range(0, 100_000).forEach(id -> {
				try {
					NpcDefinition definition = NpcDefinition.lookup(id);
					generator.add(definition.name, id);
				} catch (Exception e) {
				}
			});
			writer2.close();
		}
	}

	/*
	 * public void readValues(Stream stream) { do { int i =
	 * stream.readUnsignedByte(); if (i == 0) return; if (i == 1) { int j =
	 * stream.readUnsignedByte(); models = new int[j]; for (int j1 = 0; j1 < j;
	 * j1++) models[j1] = stream.readUnsignedWord();
	 *
	 * } else if (i == 2) name = stream.readString(); else if (i == 3) description =
	 * stream.readString(); else if (i == 12) squareLength =
	 * stream.readSignedByte(); else if (i == 13) standingAnimation =
	 * stream.readUnsignedWord(); else if (i == 14) walkingAnimation =
	 * stream.readUnsignedWord(); else if (i == 17) { walkingAnimation =
	 * stream.readUnsignedWord(); anInt58 = stream.readUnsignedWord(); anInt83 =
	 * stream.readUnsignedWord(); anInt55 = stream.readUnsignedWord(); if (anInt58
	 * == 65535) { anInt58 = -1; } if (anInt83 == 65535) { anInt83 = -1; } if
	 * (anInt55 == 65535) { anInt55 = -1; } } else if (i >= 30 && i < 40) { if
	 * (actions == null) actions = new String[5]; actions[i - 30] =
	 * stream.readString(); if (actions[i - 30].equalsIgnoreCase("hidden"))
	 * actions[i - 30] = null; } else if (i == 40) { int k =
	 * stream.readUnsignedByte(); originalColors = new int[k]; newColors = new
	 * int[k]; for (int k1 = 0; k1 < k; k1++) { originalColors[k1] =
	 * stream.readUnsignedWord(); newColors[k1] = stream.readUnsignedWord(); }
	 *
	 * } else if (i == 60) { int l = stream.readUnsignedByte(); dialogueModels = new
	 * int[l]; for (int l1 = 0; l1 < l; l1++) dialogueModels[l1] =
	 * stream.readUnsignedWord();
	 *
	 * } else if (i == 90) stream.readUnsignedWord(); else if (i == 91)
	 * stream.readUnsignedWord(); else if (i == 92) stream.readUnsignedWord(); else
	 * if (i == 93) minimapDot = false; else if (i == 95) combatLevel =
	 * stream.readUnsignedWord(); else if (i == 97) npcHeight =
	 * stream.readUnsignedWord(); else if (i == 98) npcWidth =
	 * stream.readUnsignedWord(); else if (i == 99) aBoolean93 = true; else if (i ==
	 * 100) npcWidth = stream.readSignedByte(); else if (i == 101) npcHeight
	 * =
	 * stream.readSignedByte() * 5; else if (i == 102) anInt75 =
	 * stream.readUnsignedByte(); else if (i == 103) getDegreesToTurn =
	 * stream.readUnsignedByte(); else if (i == 106) { anInt57 =
	 * stream.readUnsignedWord(); if (anInt57 == 65535) anInt57 = -1; anInt59 =
	 * stream.readUnsignedWord(); if (anInt59 == 65535) anInt59 = -1; int i1 =
	 * stream.readUnsignedByte(); childrenIDs = new int[i1 + 1]; for (int i2 = 0; i2
	 * <= i1; i2++) { childrenIDs[i2] = stream.readUnsignedWord(); if
	 * (childrenIDs[i2] == 65535) childrenIDs[i2] = -1; }
	 *
	 * } else if (i == 107) aBoolean84 = false; } while (true); }
	 */
	public static NpcDefinition copy(NpcDefinition itemDef, int newId, int copyingItemId, String newName, int[] models, int combatLevel, String... actions) {
		NpcDefinition copyItemDef = lookup(copyingItemId);
		itemDef.npcId = newId;
		itemDef.name = newName;
		itemDef.description = copyItemDef.description;
		itemDef.models = models;
		itemDef.size = copyItemDef.size;
		itemDef.standAnimation = copyItemDef.standAnimation;
		itemDef.walkAnimation = copyItemDef.walkAnimation;
		itemDef.rotate180Animation = copyItemDef.rotate180Animation;
		itemDef.rotate90RightAnimation = copyItemDef.rotate90RightAnimation;
		itemDef.rotate90LeftAnimation = copyItemDef.rotate90LeftAnimation;
		itemDef.originalColors = copyItemDef.originalColors;
		itemDef.newColors = copyItemDef.newColors;
		itemDef.originalTextures = copyItemDef.originalTextures;
		itemDef.newTextures = copyItemDef.newTextures;
		itemDef.dialogueModels = copyItemDef.dialogueModels;
		itemDef.onMinimap = copyItemDef.onMinimap;
		itemDef.combatLevel = combatLevel;
		itemDef.anInt91 = copyItemDef.anInt91;
		itemDef.anInt86 = copyItemDef.anInt86;
		itemDef.anInt75 = copyItemDef.anInt75;
		itemDef.aBoolean93 = copyItemDef.aBoolean93;
		itemDef.anInt85 = copyItemDef.anInt85;
		itemDef.anInt92 = copyItemDef.anInt92;
		itemDef.anInt75 = copyItemDef.anInt75;
		itemDef.getDegreesToTurn = copyItemDef.getDegreesToTurn;
		itemDef.anInt57 = copyItemDef.anInt57;
		itemDef.anInt59 = copyItemDef.anInt59;
		itemDef.childrenIDs = copyItemDef.childrenIDs;
		itemDef.aBoolean84 = copyItemDef.aBoolean84;
		itemDef.isClickable = copyItemDef.isClickable;
		itemDef.aBool2190 = copyItemDef.aBool2190;
		itemDef.field1914 = copyItemDef.field1914;
		itemDef.field1919 = copyItemDef.field1919;
		itemDef.field1918 = copyItemDef.field1918;
		itemDef.field1938 = copyItemDef.field1938;
		itemDef.field1920 = copyItemDef.field1920;
		itemDef.field1933 = copyItemDef.field1933;
		itemDef.field1922 = copyItemDef.field1922;
		itemDef.field1923 = copyItemDef.field1923;
		itemDef.actions = copyItemDef.actions;
		itemDef.actions = new String[10];
		if (actions != null) {
			for (int index = 0; index < actions.length; index++) {
				itemDef.actions[index] = actions[index];
			}
		}
		return itemDef;
	}
	public static NpcDefinition copy(NpcDefinition itemDef, int newId, int copyingItemId, String newName, int combatLevel, String... actions) {
		NpcDefinition copyItemDef = lookup(copyingItemId);
		itemDef.npcId = newId;
		itemDef.name = newName;
		itemDef.description = copyItemDef.description;
		itemDef.models = copyItemDef.models;
		itemDef.size = copyItemDef.size;
		itemDef.standAnimation = copyItemDef.standAnimation;
		itemDef.walkAnimation = copyItemDef.walkAnimation;
		itemDef.rotate180Animation = copyItemDef.rotate180Animation;
		itemDef.rotate90RightAnimation = copyItemDef.rotate90RightAnimation;
		itemDef.rotate90LeftAnimation = copyItemDef.rotate90LeftAnimation;
		itemDef.originalColors = copyItemDef.originalColors;
		itemDef.newColors = copyItemDef.newColors;
		itemDef.originalTextures = copyItemDef.originalTextures;
		itemDef.newTextures = copyItemDef.newTextures;
		itemDef.dialogueModels = copyItemDef.dialogueModels;
		itemDef.onMinimap = copyItemDef.onMinimap;
		itemDef.combatLevel = combatLevel;
		itemDef.anInt91 = copyItemDef.anInt91;
		itemDef.anInt86 = copyItemDef.anInt86;
		itemDef.anInt75 = copyItemDef.anInt75;
		itemDef.aBoolean93 = copyItemDef.aBoolean93;
		itemDef.anInt85 = copyItemDef.anInt85;
		itemDef.anInt92 = copyItemDef.anInt92;
		itemDef.anInt75 = copyItemDef.anInt75;
		itemDef.getDegreesToTurn = copyItemDef.getDegreesToTurn;
		itemDef.anInt57 = copyItemDef.anInt57;
		itemDef.anInt59 = copyItemDef.anInt59;
		itemDef.childrenIDs = copyItemDef.childrenIDs;
		itemDef.aBoolean84 = copyItemDef.aBoolean84;
		itemDef.isClickable = copyItemDef.isClickable;
		itemDef.aBool2190 = copyItemDef.aBool2190;
		itemDef.field1914 = copyItemDef.field1914;
		itemDef.field1919 = copyItemDef.field1919;
		itemDef.field1918 = copyItemDef.field1918;
		itemDef.field1938 = copyItemDef.field1938;
		itemDef.field1920 = copyItemDef.field1920;
		itemDef.field1933 = copyItemDef.field1933;
		itemDef.field1922 = copyItemDef.field1922;
		itemDef.field1923 = copyItemDef.field1923;
		itemDef.actions = copyItemDef.actions;
		itemDef.actions = new String[10];
		if (actions != null) {
			for (int index = 0; index < actions.length; index++) {
				itemDef.actions[index] = actions[index];
			}
		}
		return itemDef;
	}
	public int category;

	private void readValues(Buffer buffer) {
		while (true) {
			int opcode = buffer.get_unsignedbyte();
			if (opcode == 0)
				return;
			if (opcode == 1) {
				int j = buffer.get_unsignedbyte();
				models = new int[j];
				for (int j1 = 0; j1 < j; j1++)
					models[j1] = buffer.readUShort();

			} else if (opcode == 2)
				name = buffer.readString();
			else if (opcode == 12)
				size = buffer.readSignedByte();
			else if (opcode == 13)
				standAnimation = buffer.readUShort();
			else if (opcode == 14)
				walkAnimation = buffer.readUShort();
			else if (opcode == 17) {
				walkAnimation = buffer.readUShort();
				rotate180Animation = buffer.readUShort();
				rotate90RightAnimation = buffer.readUShort();
				rotate90LeftAnimation = buffer.readUShort();
				if (rotate180Animation == 65535) {
					rotate180Animation = -1;
				}
				if (rotate90RightAnimation == 65535) {
					rotate90RightAnimation = -1;
				}
				if (rotate90LeftAnimation == 65535) {
					rotate90LeftAnimation = -1;
				}
			} else if (opcode == 18) {
				category = buffer.readUShort();
			} else if (opcode >= 30 && opcode < 35) {
				if (actions == null)
					actions = new String[10];
				actions[opcode - 30] = buffer.readString();
				if (actions[opcode - 30].equalsIgnoreCase("hidden"))
					actions[opcode - 30] = null;
			} else if (opcode == 40) {
				int k = buffer.get_unsignedbyte();
				originalColors = new int[k];
				newColors = new int[k];
				for (int k1 = 0; k1 < k; k1++) {
					originalColors[k1] = buffer.readUShort();
					newColors[k1] = buffer.readUShort();
				}
			} else if (opcode == 41) {
				int k = buffer.get_unsignedbyte();
				originalTextures = new short[k];
				newTextures = new short[k];
				for (int k1 = 0; k1 < k; k1++) {
					originalTextures[k1] = (short) buffer.readUShort();
					newTextures[k1] = (short) buffer.readUShort();
				}

			} else if (opcode == 60) {
				int l = buffer.get_unsignedbyte();
				dialogueModels = new int[l];
				for (int l1 = 0; l1 < l; l1++)
					dialogueModels[l1] = buffer.readUShort();

			} else if (opcode == 93)
				onMinimap = false;
			else if (opcode == 95)
				combatLevel = buffer.readUShort();
			else if (opcode == 97)
				anInt91 = buffer.readUShort();
			else if (opcode == 98)
				anInt86 = buffer.readUShort();
			else if (opcode == 99)
				aBoolean93 = true;
			else if (opcode == 100)
				anInt85 = buffer.readSignedByte();
			else if (opcode == 101)
				anInt92 = buffer.readSignedByte();
            else if (opcode == 102) {
                int var3 = buffer.get_unsignedbyte();
                int var4 = 0;

                for(int var5 = var3; var5 != 0; var5 >>= 1) {
                    ++var4;
                }

                this.headIconArchiveIds = new int[var4];
                this.headIconSpriteIndex = new short[var4];

                for(int var6 = 0; var6 < var4; ++var6) {
                    if ((var3 & 1 << var6) == 0) {
                        this.headIconArchiveIds[var6] = -1;
                        this.headIconSpriteIndex[var6] = -1;
                    } else {
                        this.headIconArchiveIds[var6] = buffer.readNullableLargeSmart();
                        this.headIconSpriteIndex[var6] = (short)buffer.readShortSmartSub();
                    }
                }
            } else if (opcode == 103)
				getDegreesToTurn = buffer.readUShort();
			else if (opcode == 106 || opcode == 118) {
				anInt57 = buffer.readUShort();
				if (anInt57 == 65535)
					anInt57 = -1;
				anInt59 = buffer.readUShort();
				if (anInt59 == 65535)
					anInt59 = -1;
				int var3 = -1;
				if (opcode == 118)
					var3 = buffer.readUShort();
				int i1 = buffer.get_unsignedbyte();
				childrenIDs = new int[i1 + 2];
				for (int i2 = 0; i2 <= i1; i2++) {
					childrenIDs[i2] = buffer.readUShort();
					if (childrenIDs[i2] == 65535)
						childrenIDs[i2] = -1;
				}
				childrenIDs[i1 + 1] = var3;
			} else if (opcode == 107) {
				aBoolean84 = false;
			} else if (opcode == 109) {
				this.isClickable = false;
			} else if (opcode == 111) {
				this.aBool2190 = true;
			} else if (opcode == 114) {
				this.field1914 = buffer.get_unsignedshort();
			} else if (opcode == 115) {
				this.field1914 = buffer.get_unsignedshort();
				this.field1919 = buffer.get_unsignedshort();
				this.field1918 = buffer.get_unsignedshort();
				this.field1938 = buffer.get_unsignedshort();
			} else if (opcode == 116) {
				this.field1920 = buffer.get_unsignedshort();
			} else if (opcode == 117) {
				this.field1920 = buffer.get_unsignedshort();
				this.field1933 = buffer.get_unsignedshort();
				this.field1922 = buffer.get_unsignedshort();
				this.field1923 = buffer.get_unsignedshort();
			}
		}
	}

	public Model method160() {
		if (childrenIDs != null) {
			NpcDefinition entityDef = get_multi_npctype();
			if (entityDef == null)
				return null;
			else
				return entityDef.method160();
		}
		if (dialogueModels == null) {
			return null;
		}
		boolean flag1 = false;
		for (int i = 0; i < dialogueModels.length; i++)
			if (!Model.isCached(dialogueModels[i]))
				flag1 = true;

		if (flag1)
			return null;
		Model aclass30_sub2_sub4_sub6s[] = new Model[dialogueModels.length];
		for (int j = 0; j < dialogueModels.length; j++)
			aclass30_sub2_sub4_sub6s[j] = Model.getModel(dialogueModels[j]);

		Model model;
		if (aclass30_sub2_sub4_sub6s.length == 1)
			model = aclass30_sub2_sub4_sub6s[0];
		else
			model = new Model(aclass30_sub2_sub4_sub6s.length, aclass30_sub2_sub4_sub6s);

		if (originalColors != null)
			for (int k = 0; k < originalColors.length; k++)
				model.recolor(originalColors[k], newColors[k]);


		if (originalTextures != null)
			for (int k = 0; k < originalTextures.length; k++)
				model.retexture(originalTextures[k], newTextures[k]);

		return model;
	}

	public NpcDefinition get_multi_npctype() {
		int j = -1;
		if (anInt57 != -1) {
			VarBit varBit = VarBit.cache[anInt57];
			int k = varBit.setting;
			int l = varBit.start;
			int i1 = varBit.end;
			int j1 = Client.BIT_MASKS[i1 - l];
			j = clientInstance.variousSettings[k] >> l & j1;
		} else if (anInt59 != -1)
			j = clientInstance.variousSettings[anInt59];
		int var3;
		if (j >= 0 && j < childrenIDs.length)
			var3 = childrenIDs[j];
		else
			var3 = childrenIDs[childrenIDs.length - 1];
		return var3 == -1 ? null : lookup(var3);
	}

	public Model get_animated_entity_model(int primary_index, AnimationDefinition primary_seq, int[] ai, int secondary_index, AnimationDefinition secondary_seq) {
		if (childrenIDs != null) {
			NpcDefinition entityDef = get_multi_npctype();
			if (entityDef == null)
				return null;
			else
				return entityDef.get_animated_entity_model(primary_index, primary_seq, ai, secondary_index, secondary_seq);
		}
		Model model = (Model) mruNodes.get(npcId);
		if (model == null) {
			boolean flag = false;
			for (int i1 = 0; i1 < models.length; i1++)
				if (!Model.isCached(models[i1]))
					flag = true;

			if (flag)
				return null;
			Model aclass30_sub2_sub4_sub6s[] = new Model[models.length];
			for (int j1 = 0; j1 < models.length; j1++)
				aclass30_sub2_sub4_sub6s[j1] = Model.getModel(models[j1]);

			if (aclass30_sub2_sub4_sub6s.length == 1)
				model = aclass30_sub2_sub4_sub6s[0];
			else
				model = new Model(aclass30_sub2_sub4_sub6s.length, aclass30_sub2_sub4_sub6s);
			if (originalColors != null) {
				for (int k1 = 0; k1 < originalColors.length; k1++)
					model.recolor(originalColors[k1], newColors[k1]);

			}
			if (originalTextures != null) {
				for (int i1 = 0; i1 < originalTextures.length; i1++)
					model.retexture(originalTextures[i1], newTextures[i1]);
			}

			model.light(64 + anInt85, 850 + anInt92, -30, -50, -30, true);
			// model.method479(84 + npcWidth, 1000 + npcHeight
			//, -90, -580, -90, true);
			mruNodes.put(model, npcId);
		}

//		Model model_1 = Model.emptyModel;
//		model_1.replaceModel(model, AnimFrame.noAnimationInProgress(primary_index) & AnimFrame.noAnimationInProgress(secondary_index));
//		if (primary_index != -1 && secondary_index != -1) {
//			model_1.animate_dual_either(primary_seq, primary_index, secondary_seq, secondary_index);
//		} else if (primary_index != -1) {
//			model_1.animate_either(primary_seq, primary_index);
//		}
		Model model_1;
		if (primary_seq != null && secondary_seq != null) {
			model_1 = primary_seq.animate_multiple(model, primary_index, secondary_seq, secondary_index);
		} else if (primary_seq != null) {
			model_1 = primary_seq.animate_either(model, primary_index);
		} else if (secondary_seq != null) {
			model_1 = secondary_seq.animate_either(model, secondary_index);
		} else {
			model_1 = model.bake_shared_animation_model(true);
		}
		if (anInt91 != 128 || anInt86 != 128)
			model_1.scale(anInt91, anInt91, anInt86);
		model_1.calculateBoundsCylinder();
		model_1.face_label_groups = null;
		model_1.vertex_label_groups = null;
		if (size == 1)
			model_1.singleTile = true;
		return model_1;
	}

	private NpcDefinition() {
		walkAnimation = -1;
		anInt57 = walkAnimation;
		rotate180Animation = walkAnimation;
		anInt59 = walkAnimation;
		anInt59 = -1;
		combatLevel = -1;
		anInt64 = 1834;
		walkAnimation = -1;
		size = 1;
		anInt75 = -1;
		standAnimation = -1;
		npcId = -1L;
		getDegreesToTurn = 32;
		rotate90RightAnimation = -1;
		aBoolean84 = true;
		anInt86 = 128;
		onMinimap = true;
		anInt91 = 128;
		aBoolean93 = false;
		isClickable = true;
		aBool2190 = false;
	}

	@Override
	public String toString() {
		return "NpcDefinition{" +
				"npcId=" + npcId +
				", combatLevel=" + combatLevel +
				", name='" + name + '\'' +
				", actions=" + Arrays.toString(actions) +
				", walkingAnimation=" + walkAnimation +
				", size=" + size +
				", standingAnimation=" + standAnimation +
				", childrenIDs=" + Arrays.toString(childrenIDs) +
				", models=" + Arrays.toString(models) +
				'}';
	}

	public static void nullLoader() {
		mruNodes = null;
		streamIndices = null;
		cache = null;
		stream = null;
	}

	public static void dumpList() {
		try {
			File file = new File("./temp/npc_list.txt");

			if (!file.exists()) {
				file.createNewFile();
			}

			try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
				for (int i = 0; i < totalAmount; i++) {
					NpcDefinition definition = lookup(i);
					if (definition != null) {
						writer.write("npc = " + i + "\t" + definition.name + "\t" + definition.combatLevel + "\t"
								+ definition.standAnimation + "\t" + definition.walkAnimation + "\t");
						writer.newLine();
					}
				}
			}

			System.out.println("Finished dumping npc definitions.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void dumpSizes() {
		try {
			File file = new File(System.getProperty("user.home") + "/Desktop/npcSizes 143.txt");

			if (!file.exists()) {
				file.createNewFile();
			}

			try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
				for (int i = 0; i < totalAmount; i++) {
					NpcDefinition definition = lookup(i);
					if (definition != null) {
						writer.write(i + "	" + definition.size);
						writer.newLine();
					}
				}
			}

			System.out.println("Finished dumping npc definitions.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public HashMap<Integer, Object> params;
	public boolean isClickable;
	public boolean aBool2190;
	public int field1938 = -1;
	public int readyanim_r = -1;
	public int readyanim_l = -1;
	public int rotate180Animation = -1;

	public int rotate90LeftAnimation = -1;
	public int field1914 = -1;
	public int field1920 = -1;
	public int field1918 = -1;
	public int field1933 = -1;
	public int field1919 = -1;
	public int combatlevel = -1;
	public int field1923 = -1;
	public int field1922 = -1;
    int[] headIconArchiveIds = null;
    short[] headIconSpriteIndex = null;

	public static int anInt56;
	public int anInt57;

	public int anInt59;
	public static Buffer stream;
	public int combatLevel;
	public final int anInt64;
	public String name;
	public String actions[];
	public int walkAnimation;
	public byte size;
	public int[] newColors;
	public static int[] streamIndices;
	public int[] dialogueModels;
	public int anInt75;
	public int[] originalColors;
	public short[] originalTextures, newTextures;
	public int standAnimation;
	public long npcId;
	public int getDegreesToTurn;
	public static NpcDefinition[] cache;
	public static Client clientInstance;
	public int rotate90RightAnimation;
	public boolean aBoolean84;
	public int anInt85;
	public int anInt86;
	public boolean onMinimap;
	public int childrenIDs[];
	public String description;
	public int anInt91;
	public int anInt92;
	public boolean aBoolean93;
	public int[] models;
	public static ReferenceCache mruNodes = new ReferenceCache(70);
	public int[] anIntArray76;

	@Override
	public HeadIcon getOverheadIcon() {
		return null;
	}

	@Override
	public int getIntValue(int paramID) {
		return 0;
	}

	@Override
	public void setValue(int paramID, int value) {

	}

	@Override
	public String getStringValue(int paramID) {
		return null;
	}

	@Override
	public void setValue(int paramID, String value) {

	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public int[] getModels() {
		return new int[0];
	}

	@Override
	public String[] getActions() {
		return new String[0];
	}

	@Override
	public boolean isClickable() {
		return isClickable;
	}

	@Override
	public boolean isFollower() {
		return aBool2190;
	}

	@Override
	public boolean isInteractible() {
		return false;
	}

	@Override
	public boolean isMinimapVisible() {
		return onMinimap;
	}

	@Override
	public boolean isVisible() {
		return aBoolean93;
	}

	@Override
	public int getId() {
		return (int) npcId;
	}

	@Override
	public int getCombatLevel() {
		return combatLevel;
	}

	@Override
	public int[] getConfigs() {
		return new int[0];
	}

	@Override
	public RSNPCComposition transform() {
		return null;
	}

	@Override
	public int getSize() {
		return 0;
	}

	@Override
	public int getRsOverheadIcon() {
		return 0;
	}

	@Override
	public RSIterableNodeHashTable getParams() {
		return null;
	}

	@Override
	public void setParams(IterableHashTable params) {

	}

	@Override
	public void setParams(RSIterableNodeHashTable params) {

	}
}