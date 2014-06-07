package resonant.api.grid;

import java.util.HashMap;

import net.minecraftforge.common.ForgeDirection;

/** Applied to node providers in-order to get connections based on nodes. Two suggest paths to use
 * this are to either redirect to the node, or provide a list from your object.
 * 
 * @author Darkguardsman */
public interface INodeConnector
{
    public HashMap<INode, ForgeDirection> getConnections(Class<? extends INode> nodeType, ForgeDirection from);
}
