package server.logic.visitors;

import server.models.heroes.*;
import server.logic.interfaces.GameChar;

public interface HeroPowerVisitor {
    void mageVisit(Mage mage, GameChar target);
    void rogueVisit(Rogue rogue,GameChar target);
    void warlockVisit(Warlock warlock,GameChar target);
    void hunterVisit(Hunter hunter,GameChar target);
    void paladinVisit(Paladin paladin,GameChar target);
}
