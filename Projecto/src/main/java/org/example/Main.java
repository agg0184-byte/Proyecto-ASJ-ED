package org.example;

import java.util.ArrayList;
import java.util.List;

// --- CLASE ÚNICA GIGANTE (Large Class / Inappropriate Intimacy) ---
public class Main {
    public String customerName;
    public String customerEmail;
    public List<String> items = new ArrayList<>();
    public List<Double> prices = new ArrayList<>();

    // Campo temporal: Solo se usa si el envío es internacional (Temporary Field)
    public double internationalTaxRate;

    // Código muerto (Dead Code)
    private int legacyId;
    public void setLegacyId(int id) { this.legacyId = id; }

    // Método larguísimo (Long Method / Duplicate Code / Feature Envy)
    public void processOrder(String type, double distance) {
        // Lógica de cálculo (Divergent Change: si cambia el cálculo de IVA, tocas aquí)
        double total = 0;
        for (double p : prices) {
            total += p;
        }

        // Lógica de Descuentos duplicada (Duplicate Code)
        if (total > 100) {
            total = total - (total * 0.10);
        }

        // Switch complejo (Switch Statements / Object-Orientation Abuser)
        double shippingCost = 0;
        switch (type) {
            case "STANDARD":
                shippingCost = distance * 0.5;
                break;
            case "EXPRESS":
                shippingCost = distance * 1.5;
                break;
            case "INTERNATIONAL":
                // Shotgun Surgery: Si añadimos un nuevo impuesto, hay que tocar 5 sitios parecidos
                shippingCost = (distance * 2.5) + (total * internationalTaxRate);
                break;
        }

        // Impresión de factura (Feature Envy: Esta lógica debería ser de una clase Invoice)
        System.out.println("Customer: " + customerName);
        System.out.println("Total: " + total);
        System.out.println("Shipping: " + shippingCost);
        System.out.println("Final: " + (total + shippingCost));
    }

    // Otro método que hace casi lo mismo (Duplicate Code)
    public void processQuote(double total) {
        if (total > 100) {
            total = total - (total * 0.10);
        }
        System.out.println("Quote Total: " + total);
    }
}

// --- CLASE CON EXCESIVA INTIMIDAD (Inappropriate Intimacy) ---
class DeliveryService {
    public void ship(Main order) {
        // Accede directamente a los campos públicos de OrderManager en lugar de usar métodos
        System.out.println("Shipping to: " + order.customerName);
    }
}