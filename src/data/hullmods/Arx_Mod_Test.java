package data.hullmods;

import com.fs.starfarer.api.combat.BaseHullMod;
import com.fs.starfarer.api.combat.MutableShipStatsAPI;
import com.fs.starfarer.api.combat.ShipAPI.HullSize;

public class Arx_Mod_Test extends BaseHullMod {
    public static float HULL_BONUS = 100f;
    public static float S_MOD_BONUS = 2f;

    @Override
    public void applyEffectsBeforeShipCreation(HullSize hullSize, MutableShipStatsAPI stats, String id) {
        boolean isSMod = isSMod(stats);
        stats.getHullBonus().modifyPercent(id, isSMod ? HULL_BONUS * S_MOD_BONUS : HULL_BONUS);
    }

    public String getDescriptionParam(int index, HullSize hullSize) {
        if (index == 0)
            return "" + (int) HULL_BONUS + "%";
        return null;
    }

    public String getSModDescriptionParam(int index, HullSize hullSize) {
        if (index == 0)
            return "" + (int) (S_MOD_BONUS * HULL_BONUS - HULL_BONUS) + "%";
        return null;
    }
}
