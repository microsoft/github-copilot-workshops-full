using System;
using System.ComponentModel.DataAnnotations;

namespace HearingAidsStoreApp.Models;

public class PurchaseOrder
{
    public int ID { get; set; }
    public int CustomerId { get; set; }
    public int ProductId { get; set; }

    [DataType(DataType.Date)]
    public DateTime PurchaseDate { get; set; }


    // Navigation property
    public Customer? Customer { get; set; }
    public Product? Product { get; set; }

}
