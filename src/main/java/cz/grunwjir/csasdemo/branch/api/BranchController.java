package cz.grunwjir.csasdemo.branch.api;

import cz.grunwjir.csasdemo.Page;
import cz.grunwjir.csasdemo.branch.model.Branch;
import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * The REST API controller for branch endpoint.
 *
 * @author Jiri Grunwald
 */
@RequestMapping(value = "/branches", produces = MediaType.APPLICATION_JSON_VALUE)
public interface BranchController {

    @GetMapping
    @Operation(summary = "Searches Csas branches by its name or address")
    Page<Branch> searchBranches(
            @ApiParam(value = "search text, can be branch name or address")
            @RequestParam String query,
            @ApiParam(value = "page size")
            @RequestParam(required = false) Integer size,
            @ApiParam(value = "selected page, first page is 0")
            @RequestParam(required = false) Integer page);
}