using Microsoft.EntityFrameworkCore;

public class ApplicationDbContext : DbContext
{
    public ApplicationDbContext(DbContextOptions<ApplicationDbContext> options)
        : base(options)
    {
    }

    public DbSet<HearingAidsStoreApp.Models.Customer> Customer { get; set; } = default!;
    public DbSet<HearingAidsStoreApp.Models.Product> Products { get; set; } = default!;
    public DbSet<HearingAidsStoreApp.Models.PurchaseOrder> PurchaseOrder { get; set; } = default!;
}
