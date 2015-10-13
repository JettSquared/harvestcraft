/*    */ package com.pam.harvestcraft;
/*    */ 
/*    */ import cpw.mods.fml.common.eventhandler.SubscribeEvent;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.entity.passive.EntitySheep;
/*    */ import net.minecraftforge.event.entity.living.LivingDropsEvent;
/*    */ 
/*    */ public class PamSheepDrops
/*    */ {
/*    */   public static double rand;
/*    */   
/*    */   @SubscribeEvent
/*    */   public void onEntityDrop(LivingDropsEvent event)
/*    */   {
/* 15 */     if (event.source.getDamageType().equals("player"))
/*    */     {
/* 17 */       rand = Math.random();
/* 18 */       if ((event.entityLiving instanceof EntitySheep))
/*    */       {
/* 20 */         if (rand < 0.5D) {
/* 21 */           event.entityLiving.dropItem(ItemRegistry.muttonrawItem, 1);
/*    */         }
/* 23 */         if (rand < 0.25D) {
/* 24 */           event.entityLiving.dropItem(ItemRegistry.muttonrawItem, 1);
/*    */         }
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Modding\Desktop\Pam's HarvestCraft 1.7.10k.deobf.jar!\com\pam\harvestcraft\PamSheepDrops.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */