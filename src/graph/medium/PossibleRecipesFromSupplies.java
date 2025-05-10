package graph.medium;

import java.util.*;

public class PossibleRecipesFromSupplies {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Map<String, List<String>> adjMap = new HashMap<>();
        Map<String, Integer> inDegree = new HashMap<>();
        Queue<String> queue = new LinkedList<>();
        Set<String> supplySet = new HashSet<>();
        List<String> result = new ArrayList<>();

        for (String recipe : recipes) {
            inDegree.put(recipe, 0);
        }

        for (String supply : supplies) {
            supplySet.add(supply);
        }

        for (int i = 0; i < recipes.length; i++) {
            String recipe = recipes[i];
            List<String> ingredient = ingredients.get(i);
            for (String ing : ingredient) {
                if (supplySet.contains(ing))
                    continue;
                if (!adjMap.containsKey(ing)) {
                    List<String> adj = new ArrayList<>();
                    adj.add(recipe);
                    adjMap.put(ing, adj);
                } else {
                    adjMap.get(ing).add(recipe);
                }
                inDegree.put(recipe, inDegree.getOrDefault(recipe, 0) + 1);
            }
        }

        for (Map.Entry<String, Integer> entry : inDegree.entrySet()) {
            if (entry.getValue() == 0) {
                queue.offer(entry.getKey());
                result.add(entry.getKey());
            }
        }


        while (!queue.isEmpty()) {
            String top = queue.poll();
            if (adjMap.get(top) == null)
                continue;
            for (String adj : adjMap.get(top)) {
                inDegree.put(adj, inDegree.getOrDefault(adj, 0) - 1);
                if (inDegree.get(adj) == 0) {
                    queue.offer(adj);
                    result.add(adj);
                }
            }
        }
        return result;
    }
}


class PossibleRecipesFromSuppliesTest {
    public static void main(String[] args) {
        String[] recipes = {"bread", "sandwich"};
        String[] supplies = {"yeast", "flour", "meat"};
        List<String> ingredient1 = List.of("yeast", "flour");
        List<String> ingredient2 = List.of("bread", "meat");

        List<List<String>> ingredients = new ArrayList<>();
        ingredients.add(ingredient1);
        ingredients.add(ingredient2);

        PossibleRecipesFromSupplies possibleRecipesFromSupplies = new PossibleRecipesFromSupplies();
        List<String> results = possibleRecipesFromSupplies.findAllRecipes(recipes, ingredients, supplies);
        for (String result : results) {
            System.out.println(result);
        }
    }
}
