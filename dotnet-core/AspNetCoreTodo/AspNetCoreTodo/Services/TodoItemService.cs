﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using AspNetCoreTodo.Data;
using AspNetCoreTodo.Models;
using Microsoft.EntityFrameworkCore;

namespace AspNetCoreTodo.Services
{
    public class TodoItemService : ITodoItemService
    {
        private readonly ApplicationDbContext _context;

        public TodoItemService(ApplicationDbContext context)
        {
            _context = context;
        }

        public async Task<ToDoItem[]> GetIncompleteItemsAsync()
        {
            return await _context.Items
                .Where(x => x.isDone == false)
                .ToArrayAsync();
        }

        public async Task<bool> AddItemAsync(ToDoItem newItem)
        {
            newItem.ID = Guid.NewGuid();
            newItem.isDone = false;
            newItem.DueAt = DateTimeOffset.Now.AddDays(3);

            _context.Items.Add(newItem);

            var saveResult = await _context.SaveChangesAsync();
            return saveResult == 1;
        }

        public async Task<bool> MarkDoneAsync(Guid id)
        {
            var item = await _context.Items
                .Where(x => x.ID == id)
                .SingleOrDefaultAsync();

            if (item == null)
            {
                return false;
            }

            item.isDone = true;

            var saveResult = await _context.SaveChangesAsync();
            return saveResult == 1;
        }
    }
}