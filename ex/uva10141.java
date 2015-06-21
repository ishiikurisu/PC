import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.HashMap;
import java.util.TreeSet;

public class uva10141
{
    static InputStreamReader ISR = new InputStreamReader(System.in);
    static BufferedReader BR = new BufferedReader(ISR);

    static int numberRequirements;
    static int numberProposals;
    static TreeSet<String> requirements;
    static TreeSet<String> proposalNames;
    static HashMap<String, Integer> proposals;
    static HashMap<String, Double> prices;

    static double compliance(double proposalsMet)
    {
        return (proposalsMet / numberProposals);
    }

    static void setup()
    throws IOException
    {
        String[] line = BR.readLine().split(" ");
        String proposal = null;
        String option = null;
        double proposalCost = 0.0;
        int proposalOptions = 0;

        numberRequirements = Integer.parseInt(line[0]);
        numberProposals = Integer.parseInt(line[1]);

        if (numberRequirements == 0 && numberProposals == 0)
            throw new IOException();

        requirements = new TreeSet<String>();
        for (int n = 0; n < numberRequirements; ++n)
            requirements.add(BR.readLine());

        proposals = new HashMap<String, Integer>();
        proposalNames = new TreeSet<String>();
        prices = new HashMap<String, Double>();

        for (int p = 0; p < numberProposals; ++p)
        {
            proposal = BR.readLine();
            line = BR.readLine().split(" ");
            proposalCost = Double.parseDouble(line[0]);
            proposalOptions = Integer.parseInt(line[1]);

            proposalNames.add(proposal);
            prices.put(proposal, proposalCost);
            proposals.put(proposal, 0);

            for (int i = 0; i < proposalOptions; ++i)
            {
                option = BR.readLine();
                if (requirements.contains(option))
                    proposals.put(proposal, proposals.get(proposal) + 1);
            }
        }
    }

    static void draw()
    {
        double bestCompliance = -1;
        String bestProposal = null;
        double currentCompliance = -2;

        for (String proposal: proposalNames)
        {
            currentCompliance = compliance(proposals.get(proposal));

            if (currentCompliance > bestCompliance) {
                bestProposal = proposal;
                bestCompliance = currentCompliance;
            }
            else if (currentCompliance == bestCompliance) {
                if (prices.get(bestProposal) > prices.get(proposal))
                    bestProposal = proposal;
            }
        }

        System.out.println(bestProposal);
    }

    public static void main(String[] args)
    throws IOException
    {
        while (true)
        {
            try {
                setup();
                draw();
            }
            catch (Exception any) {
                break;
            }
        }

        BR.close();
        ISR.close();
    }
}
