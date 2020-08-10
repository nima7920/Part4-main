package server.logic.visitors;

import server.logic.gameState.GameChar;
import server.logic.gameState.GamerMinionState;
import server.logic.util.PlayGroundEditor;
import server.models.allCards.*;
import server.models.cards.Ability;
import server.models.cards.CardClass;
import server.models.cards.Rarity;

public class CardPlayVisitor implements CardVisitor{
    private PlayGroundEditor playGroundEditor;

    public CardPlayVisitor(PlayGroundEditor playGroundEditor) {
        this.playGroundEditor = playGroundEditor;
    }

    @Override
    public void polymorphVisit(Polymorph polymorph, GameChar target) {
        playGroundEditor.transformMinion(target, new CustomMinion(1, 1));
    }

    @Override
    public void dreadscaleVisit(Dreadscale dreadscale, GameChar target) {

    }

    @Override
    public void riverCrocoliskVisit(RiverCrocolisk riverCrocolisk, GameChar target) {

    }

    @Override
    public void arcaneServantVisit(ArcaneServant arcaneServant, GameChar target) {

    }

    @Override
    public void silverbackPatriarchVisit(SilverbackPatriarch silverbackPatriarch, GameChar target) {

    }

    @Override
    public void phantomMilitiaVisit(PhantomMilitia phantomMilitia, GameChar target) {

    }

    @Override
    public void murlocRaiderVisit(MurlocRaider murlocRaider, GameChar target) {

    }

    @Override
    public void stonetuskBoarVisit(StonetuskBoar stonetuskBoar, GameChar target) {

    }

    @Override
    public void rottenApplebaumVisit(RottenApplebaum rottenApplebaum, GameChar target) {

    }

    @Override
    public void theBlackKnightVisit(TheBlackKnight theBlackKnight, GameChar target) {

    }

    @Override
    public void proudDefenderVisit(ProudDefender proudDefender, GameChar target) {

    }

    @Override
    public void fireballVisit(Fireball fireball, GameChar target) {
        target.setHp(target.getHp() - 6);
    }

    @Override
    public void arcaneMissilesVisit(ArcaneMissiles arcaneMissiles, GameChar target) {
        playGroundEditor.randomDamageToAll(3);
    }

    @Override
    public void assassinateVisit(Assassinate assassinate, GameChar target) {
        target.setHp(0);
    }

    @Override
    public void sinisterStrikeVisit(SinisterStrike sinisterStrike, GameChar target) {
        playGroundEditor.damageHero(3);
    }

    @Override
    public void hellfireVisit(Hellfire hellfire, GameChar target) {
        playGroundEditor.damageToAll(3);
    }

    @Override
    public void drainLifeVisit(DrainLife drainLife, GameChar target) {
        target.setHp(target.getHp() - 2);
        playGroundEditor.restoreHero(2);
    }

    @Override
    public void arcaneExplosionVisit(ArcaneExplosion arcaneExplosion, GameChar target) {
        playGroundEditor.damageToAllMinions(1);
    }

    @Override
    public void ironFistVisit(IronFist ironFist, GameChar target) {
        playGroundEditor.damageHero(5);
    }

    @Override
    public void bookOfSpectersVisit(BookOfSpecters bookOfSpecters, GameChar target) {
        playGroundEditor.drawIfNotSpell(3);
    }

    @Override
    public void sprintVisit(Sprint sprint, GameChar target) {
        playGroundEditor.drawOneCard();
        playGroundEditor.drawOneCard();
        playGroundEditor.drawOneCard();
        playGroundEditor.drawOneCard();
    }

    @Override
    public void swarmOfLocustsVisit(SwarmOfLocusts swarmOfLocusts, GameChar target) {
        playGroundEditor.summonMinion(new CustomMinion(1, 1), 7);
    }

    @Override
    public void pharaohBlessingVisit(PharaohsBlessing pharaohsBlessing, GameChar target) {
        GamerMinionState minionTarget = (GamerMinionState) target;
        minionTarget.setAttack(minionTarget.getAttack() + 4);
        minionTarget.setHp(minionTarget.getHp() + 4);
        minionTarget.addAbility(Ability.DivineShield);
        minionTarget.addAbility(Ability.Taunt);
        minionTarget.setEnabled(true);
    }

    @Override
    public void sathrovarrVisit(Sathrovarr sathrovarr, GameChar target) {
        playGroundEditor.addCardToDeck(target.getName());
        playGroundEditor.addCardToHand(target.getName());
        playGroundEditor.addMinionToGround(target.getName());
    }

    @Override
    public void tombWardenVisit(TombWarden tombWarden, GameChar target) {
        playGroundEditor.summonMinion(new TombWarden("Tomb Warden", 8, 9, CardClass.Neutral, Rarity.Rare, "Taunt Battlecry: Summon a copy of this minion", 3, 6)
                , 1);
    }

    @Override
    public void securityRoverVisit(SecurityRover securityRover, GameChar target) {

    }

    @Override
    public void curioCollectorVisit(CurioCollector curioCollector, GameChar target) {

    }

    @Override
    public void strengthInNumbersVisit(StrengthInNumbers strengthinNumbers, GameChar target) {

    }

    @Override
    public void learnDraconicVisit(LearnDraconic learnDraconic, GameChar target) {

    }

    @Override
    public void wickedKnifeVisit(WickedKnife wickedKnife, GameChar target) {
        playGroundEditor.setWeapon(new WickedKnife("Wicked Knife", "", Rarity.Common, CardClass.Neutral, 1, 1, 1, 2));

    }

    @Override
    public void bloodFuryVisit(BloodFury bloodFury, GameChar target) {
        playGroundEditor.setWeapon(new BloodFury("Blood Fury", "", Rarity.Common, CardClass.Neutral, 4, 3, 3, 8));
    }

    @Override
    public void heavyAxeVisit(HeavyAxe heavyAxe, GameChar target) {
        playGroundEditor.setWeapon(new HeavyAxe("Heavy Axe", "", Rarity.Common, CardClass.Neutral, 1, 1, 1, 3));
    }


    @Override
    public void friendlySmithVisit(FriendlySmith friendlySmith, GameChar target) {
        playGroundEditor.addDiscover(new String[]{"Wicked Knife", "Heavy Axe", "Blood Fury"});
    }

    @Override
    public void swampKingDredVisit(SwampKingDred swampKingDred, GameChar target) {

    }

    @Override
    public void multiShotVisit(MultiShot multiShot, GameChar target) {
        target.setHp(target.getHp() - 2);
    }

    @Override
    public void gnomishArmyKnifeVisit(GnomishArmyKnife gnomishArmyKnife, GameChar target) {
        GamerMinionState targetMinion = (GamerMinionState) target;
        targetMinion.addAbility(Ability.Charge);
        targetMinion.addAbility(Ability.Taunt);
        targetMinion.addAbility(Ability.DivineShield);
        targetMinion.addAbility(Ability.WindFury);
        targetMinion.addAbility(Ability.LifeSteal);
        targetMinion.addAbility(Ability.Poisonous);
    }

    @Override
    public void consecrationVisit(Consecration consecration, GameChar target) {
        playGroundEditor.damageToAll(2);
    }


    @Override
    public void customMinionVisit(CustomMinion customMinion, GameChar target) {

    }
}
