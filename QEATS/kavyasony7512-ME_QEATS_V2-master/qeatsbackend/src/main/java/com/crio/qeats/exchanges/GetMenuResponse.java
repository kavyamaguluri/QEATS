package com.crio.qeats.exchanges;

import com.crio.qeats.dto.Menu;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetMenuResponse {
  private Menu menu;
}
