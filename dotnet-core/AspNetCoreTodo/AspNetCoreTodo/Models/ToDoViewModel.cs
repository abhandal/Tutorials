using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using AspNetCoreTodo.Models;

namespace AspNetCoreTodo.Views
{
    public class ToDoViewModel
    {
        public ToDoItem[] Items { get; set; }
    }
}
