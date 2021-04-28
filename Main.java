import java.io.FileInputStream;

import syntaxtree.*;
import symbol_table.*;

public class Main {
	public static void main(String[] args) {
		if (args.length < 1) {
			System.err.println("You need to pass arguments like so: <inputFile1> <inputfile2> ... <inputFileN>");
			System.exit(1);
		}

		for (String filename: args) {
			/* Pretty-print file basename */
			String basename = filename.substring(filename.lastIndexOf('/') + 1);
			System.out.println(String.format("%-80s", basename).replace(' ', '=').replaceFirst("=", " "));

			try (FileInputStream input = new FileInputStream(filename)) {
				/* Parsing */
				Goal root = new MiniJavaParser(input).Goal();
				System.out.println("Parsing was successful.");

				/* Semantic Checking Phase 1: Populate Symbol Table */
				SymbolTable symbols = new SymbolTable();

				SymbolVisitor firstPhase = new SymbolVisitor(symbols);
				root.accept(firstPhase, null);

				/* TODO: Semantic Checking Phase 2: Type checking, using Symbol Table (probably?)
				SymbolVisitor firstPhase = new SymbolVisitor(symbols);
				root.accept(firstPhase, null); */

				/* TODO: Print offsets */
			} catch (Exception e) {
				e.printStackTrace();
			}

			System.out.println();
		}
	}
}
