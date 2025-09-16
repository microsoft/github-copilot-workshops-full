using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.RazorPages;
using Microsoft.EntityFrameworkCore;
using HearingAidsStoreApp.Models;

namespace HearingAidsStoreApp.Pages.PurchaseOrders
{
    public class DetailsModel : PageModel
    {
        private readonly ApplicationDbContext _context;

        public DetailsModel(ApplicationDbContext context)
        {
            _context = context;
        }

        public PurchaseOrder PurchaseOrder { get; set; } = default!;

        public async Task<IActionResult> OnGetAsync(int? id)
        {
            if (id == null)
            {
                return NotFound();
            }

            var purchaseOrder = await _context.PurchaseOrder.Include(p => p.Customer).Include(p => p.Product).FirstOrDefaultAsync(m => m.ID == id);
            if (purchaseOrder == null)
            {
                return NotFound();
            }
            else
            {
                PurchaseOrder = purchaseOrder;
            }
            return Page();
        }
    }
}
