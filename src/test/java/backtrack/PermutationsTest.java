package backtrack;


import org.junit.jupiter.api.Test;

public class PermutationsTest {

    @Test
    public void permute() {
        Permutations permutations = new Permutations();
        System.out.println(permutations.permute(new int[]{3, 5, 9}));
    }
}