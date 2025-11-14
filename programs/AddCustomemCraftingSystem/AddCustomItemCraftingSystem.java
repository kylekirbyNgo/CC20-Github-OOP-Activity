package programs.AddCustomemCraftingSystem;

import core.ProgramInterface;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner; // ✅ Make sure this exists!

 /**
  * Add Custom Item Crafting System
  * An interactive crafting system featuring legendary weapons,potions,and artifacts.
  *
  *Author : Kyle Kirby M. Ngo
  *
  */


public class AddCustomItemCraftingSystem implements ProgramInterface {

    public String getName() { 
        return "Add Custom Item Crafting System"; 
    }

    public String getDescription() { 
        return "An interactive crafting system featuring legendary weapons, potions, and artifacts."; 
    }

    public String getAuthor() { 
        return "Kyle Kirby M. Ngo"; 
    }

    // ✅ INTERFACE (Abstraction)
    interface Craftable {
        void craft();
        String getName();
    }

    // ✅ BASE CLASS (Abstraction + Encapsulation)
    abstract class CustomItem implements Craftable {
        private String name;
        private int powerLevel;

        public CustomItem(String name, int powerLevel) {
            this.name = name;
            this.powerLevel = powerLevel;
        }

        public String getName() { return name; }
        public int getPowerLevel() { return powerLevel; }
        public void setPowerLevel(int powerLevel) { this.powerLevel = powerLevel; }

        public abstract void craft();
    }

    // ✅ SUBCLASSES (Inheritance + Polymorphism)
    class CustomWeapon extends CustomItem {
        public CustomWeapon(String name, int powerLevel) {
            super(name, powerLevel);
        }

        @Override
        public void craft() {
            System.out.println("⚔️ Forging weapon: " + getName() + " (Power Level: " + getPowerLevel() + ")");
        }
    }

    class CustomPotion extends CustomItem {
        public CustomPotion(String name, int powerLevel) {
            super(name, powerLevel);
        }

        @Override
        public void craft() {
            System.out.println("🧪 Brewing potion: " + getName() + " (Potency: " + getPowerLevel() + ")");
        }
    }

    class CustomArtifact extends CustomItem {
        public CustomArtifact(String name, int powerLevel) {
            super(name, powerLevel);
        }

        @Override
        public void craft() {
            System.out.println("💎 Enchanting artifact: " + getName() + " (Mystic Power: " + getPowerLevel() + ")");
        }
    }

    // ✅ Main logic
    public void run() {
        Scanner scanner = new Scanner(System.in);
        List<CustomItem> craftedItems = new ArrayList<>();

        System.out.println("🎮 Welcome to the Custom Crafting System!");
        System.out.println("------------------------------------------");

        boolean running = true;
        while (running) {
            System.out.println("\nWhat would you like to craft?");
            System.out.println("1️⃣  Weapon");
            System.out.println("2️⃣  Potion");
            System.out.println("3️⃣  Artifact");
            System.out.println("4️⃣  Show all crafted items");
            System.out.println("5️⃣  Exit");
            System.out.print("Enter your choice: ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("❌ Invalid input! Please enter a number (1–5).");
                continue;
            }

            switch (choice) {
                case 1 -> craftWeapon(scanner, craftedItems);
                case 2 -> craftPotion(scanner, craftedItems);
                case 3 -> craftArtifact(scanner, craftedItems);
                case 4 -> showCraftedItems(craftedItems);
                case 5 -> {
                    System.out.println("👋 Exiting crafting system. Goodbye!");
                    running = false;
                }
                default -> System.out.println("❌ Invalid choice. Try again.");
            }
        }
        scanner.close();
    }

    private void craftWeapon(Scanner scanner, List<CustomItem> craftedItems) {
        System.out.println("\nChoose a weapon to craft:");
        String[] weapons = {"Katana of the Sun", "Shadowfang Dagger", "Stormbreaker Axe", "Frostbite Spear", "Infernal Scythe"};
        int[] power = {18, 15, 20, 17, 22};

        for (int i = 0; i < weapons.length; i++) {
            System.out.println((i + 1) + ". " + weapons[i] + " (Power: " + power[i] + ")");
        }
        System.out.print("Enter choice: ");
        int pick = Integer.parseInt(scanner.nextLine());

        if (pick < 1 || pick > weapons.length) {
            System.out.println("❌ Invalid selection!");
            return;
        }

        CustomWeapon weapon = new CustomWeapon(weapons[pick - 1], power[pick - 1]);
        weapon.craft();
        craftedItems.add(weapon);
    }

    private void craftPotion(Scanner scanner, List<CustomItem> craftedItems) {
        System.out.println("\nChoose a potion to brew:");
        String[] potions = {"Elixir of Swiftness", "Tonic of Titans", "Dragon’s Breath Ale"};
        int[] potency = {8, 10, 9};

        for (int i = 0; i < potions.length; i++) {
            System.out.println((i + 1) + ". " + potions[i] + " (Potency: " + potency[i] + ")");
        }
        System.out.print("Enter choice: ");
        int pick = Integer.parseInt(scanner.nextLine());

        if (pick < 1 || pick > potions.length) {
            System.out.println("❌ Invalid selection!");
            return;
        }

        CustomPotion potion = new CustomPotion(potions[pick - 1], potency[pick - 1]);
        potion.craft();
        craftedItems.add(potion);
    }

    private void craftArtifact(Scanner scanner, List<CustomItem> craftedItems) {
        System.out.println("\nChoose an artifact to enchant:");
        String[] artifacts = {"Boots of the Wind", "Helm of Eternity", "Ring of Regeneration", "Cloak of Shadows", "Orb of Teleportation", "Soul Gem", "Compass of Truth", "Phoenix Chestplate"};
        int[] mysticPower = {11, 13, 9, 12, 15, 14, 10, 16};

        for (int i = 0; i < artifacts.length; i++) {
            System.out.println((i + 1) + ". " + artifacts[i] + " (Mystic Power: " + mysticPower[i] + ")");
        }
        System.out.print("Enter choice: ");
        int pick = Integer.parseInt(scanner.nextLine());

        if (pick < 1 || pick > artifacts.length) {
            System.out.println("❌ Invalid selection!");
            return;
        }

        CustomArtifact artifact = new CustomArtifact(artifacts[pick - 1], mysticPower[pick - 1]);
        artifact.craft();
        craftedItems.add(artifact);
    }

    private void showCraftedItems(List<CustomItem> items) {
        if (items.isEmpty()) {
            System.out.println("📦 No items crafted yet.");
            return;
        }

        System.out.println("\n📜 Crafted Items:");
        for (CustomItem item : items) {
            System.out.println(" - " + item.getName() + " (Power: " + item.getPowerLevel() + ")");
        }
    }

    public static void main(String[] args) {
        AddCustomItemCraftingSystem program = new AddCustomItemCraftingSystem();
        program.run();
    }
}
