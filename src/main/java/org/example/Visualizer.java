package org.example;

import javax.swing.*;
import java.awt.*;

class Visualizer extends JFrame {
    private int[] distribution;
    private DistributionPanel distributionPanel;

    public Visualizer() {
        distribution = new int[100]; // Ejemplo: 100 contenedores
        distributionPanel = new DistributionPanel();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 400);
        add(distributionPanel);

        setVisible(true);
    }

    public void updateDistribution(int[] newDistribution) {
        distribution = newDistribution;
        distributionPanel.repaint();
    }

    private class DistributionPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            int width = getWidth() / distribution.length;

            for (int i = 0; i < distribution.length; i++) {
                int x = i * width;
                int barHeight = distribution[i];

                // Dibuja las barras con colores basados en la cantidad de componentes
                g.setColor(Color.BLUE); // Puedes personalizar el color
                g.fillRect(x, getHeight() - barHeight, width, barHeight);
            }
        }
    }
}
