package de.blazemcworld.fireflow.code.node.impl.number;

import de.blazemcworld.fireflow.code.node.Node;
import de.blazemcworld.fireflow.code.type.NumberType;
import net.minecraft.item.Items;

public class MultiplyNumbersNode extends Node {
    
    public MultiplyNumbersNode() {
        super("multiply_numbers", "Multiply Numbers", "Multiplies multiple numbers together", Items.SMITHING_TABLE);
        
        Input<Double> left = new Input<>("left", "Left", NumberType.INSTANCE);
        Varargs<Double> right = new Varargs<>("right", "Right", NumberType.INSTANCE);
        Output<Double> result = new Output<>("result", "Result", NumberType.INSTANCE);

        result.valueFrom((ctx) -> {
            double out = left.getValue(ctx);
            for (double v : right.getVarargs(ctx)) out *= v;
            return out;
        });
    }

    @Override
    public Node copy() {
        return new MultiplyNumbersNode();
    }

}
